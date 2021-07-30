package com.example.music.controller;

import com.example.music.bean.SingerDTO;
import com.example.music.domain.Singer;
import com.example.music.response.RestResponse;
import com.example.music.service.impl.SingerServiceImpl;
import com.example.music.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class SingerController implements BaseController {

    @Autowired
    private SingerServiceImpl singerService;

    /**
     * 添加歌手
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 09:00
     **/
    @RequestMapping(value = "/singer/add", method = RequestMethod.POST)
    public RestResponse addSinger(HttpServletRequest req) {
        SingerDTO singer = toPojo(req, SingerDTO.class);
        singer.setBirth(DateUtils.toDate(singer.getBirthStr()));
        boolean res = singerService.addSinger(singer);
        if (res) {
            return RestResponse.success("添加成功");
        } else {
            return RestResponse.fail("添加失败");
        }
    }

    /**
     * 返回所有歌手
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 09:00
     **/
    @RequestMapping(value = "/singer", method = RequestMethod.GET)
    public RestResponse allSinger() {
        return RestResponse.success(singerService.allSinger());
    }

    /**
     * 根据歌手名查找歌手
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 09:00
     **/
    @RequestMapping(value = "/singer/name/detail", method = RequestMethod.GET)
    public RestResponse singerOfName(String name) {
        return RestResponse.success(singerService.singerOfName(name));
    }

    /**
     * 根据歌手性别查找歌手
     *
     * @param sex 性别，0：女 1：男
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 09:01
     **/
    @RequestMapping(value = "/singer/sex/detail", method = RequestMethod.GET)
    public RestResponse singerOfSex(Integer sex) {
        return RestResponse.success(singerService.singerOfSex(sex));
    }

    /**
     * 删除歌手
     *
     * @param id 歌手id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 09:03
     **/
    @RequestMapping(value = "/singer/delete", method = RequestMethod.GET)
    public RestResponse deleteSinger(Integer id) {
        if (singerService.deleteSinger(id)) {
            return RestResponse.success("删除成功");
        } else {
            return RestResponse.fail("删除失败");
        }
    }

    /**
     * 更新歌手信息
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 09:03
     **/
    @RequestMapping(value = "/singer/update", method = RequestMethod.POST)
    public RestResponse updateSingerMsg(HttpServletRequest req) {
        SingerDTO singer = toPojo(req, SingerDTO.class);
        singer.setBirth(DateUtils.toDate(singer.getBirthStr()));
        boolean res = singerService.updateSingerMsg(singer);
        if (res) {
            return RestResponse.success("添加成功");
        } else {
            return RestResponse.fail("修改失败");
        }
    }

    /**
     * 更新歌手头像
     *
     * @param avatarFile 头像图片
     * @param id         歌手id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 09:04
     **/
    @RequestMapping(value = "/singer/avatar/update", method = RequestMethod.POST)
    public RestResponse updateSingerPic(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") int id) {
        if (avatarFile.isEmpty()) {
            log.info("更新歌手头像失败，上传文件为空");
            return RestResponse.fail("文件上传失败！");
        }
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + File.separator + "img" + File.separator + "singerPic";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            boolean mkdir = file1.mkdir();
            if (!mkdir) {
                log.info("更新歌手头像失败，文件夹未创建");
                return RestResponse.fail("文件上传失败！");
            }
        }
        File dest = new File(filePath + File.separator + fileName);
        String storeAvatarPath = "/img/singerPic/" + fileName;
        try {
            avatarFile.transferTo(dest);
            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(storeAvatarPath);
            boolean res = singerService.updateSingerPic(singer);
            if (res) {
                return RestResponse.success("上传成功", storeAvatarPath);
            } else {
                return RestResponse.fail("上传失败");
            }
        } catch (IOException e) {
            log.error("更新歌手头像失败", e);
            return RestResponse.fail("上传失败");
        }
    }
}

