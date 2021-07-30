package com.example.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.music.domain.SongList;
import com.example.music.response.RestResponse;
import com.example.music.service.impl.SongListServiceImpl;
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
public class SongListController implements BaseController {

    @Autowired
    private SongListServiceImpl songListService;

    /**
     * 添加歌单
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:05
     **/
    @RequestMapping(value = "/songList/add", method = RequestMethod.POST)
    public RestResponse addSongList(HttpServletRequest req) {
        SongList songList = toPojo(req, SongList.class);
        boolean res = songListService.addSongList(songList);
        if (res) {
            return RestResponse.success("添加成功");
        } else {
            return RestResponse.fail("添加失败");
        }
    }

    /**
     * 返回所有歌单
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:05
     **/
    @RequestMapping(value = "/songList")
    public RestResponse allSongList() {
        return RestResponse.success(songListService.allSongList());
    }

    /**
     * 返回指定标题对应的歌单
     *
     * @param title 歌单标题
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:06
     **/
    @RequestMapping(value = "/songList/title/detail")
    public RestResponse songListOfTitle(String title) {
        return RestResponse.success(songListService.songListOfTitle(title));
    }

    /**
     * 返回标题包含文字的歌单
     *
     * @param title
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:06
     **/
    @RequestMapping(value = "/songList/likeTitle/detail")
    public RestResponse songListOfLikeTitle(String title) {
        return RestResponse.success(songListService.likeTitle(title));
    }

    /**
     * 返回指定类型的歌单
     *
     * @param style 歌单类型
     *              6     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:09
     **/
    @RequestMapping(value = "/songList/style/detail")
    public RestResponse songListOfStyle(String style) {
        return RestResponse.success(songListService.likeStyle(style));
    }

    /**
     * 删除歌单
     *
     * @param id 歌单id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:26
     **/
    @RequestMapping(value = "/songList/delete")
    public RestResponse deleteSongList(Integer id) {
        boolean res = songListService.deleteSongList(id);
        if (res) {
            return RestResponse.success("删除成功");
        } else {
            return RestResponse.fail("删除失败");
        }
    }

    /**
     * 更新歌单信息
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:26
     **/
    @RequestMapping(value = "/songList/update", method = RequestMethod.POST)
    public RestResponse updateSongListMsg(HttpServletRequest req) {
        SongList songList = toPojo(req, SongList.class);
        boolean res = songListService.updateSongListMsg(songList);
        if (res) {
            return RestResponse.success("修改成功");
        } else {
            return RestResponse.fail("修改失败");
        }
    }

    /**
     * 更新歌单图片
     *
     * @param avatarFile 歌单图片
     * @param id         歌单id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:27
     **/
    @RequestMapping(value = "/songList/img/update", method = RequestMethod.POST)
    public RestResponse updateSongListPic(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") int id) {
        if (avatarFile.isEmpty()) {
            log.info("文件上传失败，文件为空");
            return RestResponse.fail("文件上传失败！");
        }
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + File.separator + "img" + File.separator + "songListPic";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            if (!file1.mkdirs()) {
                log.info("文件上传失败，文件夹创建失败");
                return RestResponse.fail("文件上传失败！");
            }
        }
        File dest = new File(filePath + File.separator + fileName);
        String storeAvatarPath = "/img/songListPic/" + fileName;
        try {
            avatarFile.transferTo(dest);
            SongList songList = new SongList();
            songList.setId(id);
            songList.setPic(storeAvatarPath);
            boolean res = songListService.updateSongListImg(songList);
            if (res) {
                return RestResponse.success("上传成功", storeAvatarPath);
            } else {
                return RestResponse.fail("文件上传失败！");
            }
        } catch (IOException e) {
            return RestResponse.fail("文件上传失败！");
        }
    }
}















