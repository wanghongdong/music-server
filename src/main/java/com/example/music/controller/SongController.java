package com.example.music.controller;

import com.example.music.domain.Song;
import com.example.music.response.RestResponse;
import com.example.music.service.impl.SongServiceImpl;
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
import java.util.Date;

@Slf4j
@RestController
public class SongController implements BaseController {

    @Autowired
    private SongServiceImpl songService;

    private static final String DEFAULT_SONG_PIC_PATH = "/img/songPic/tubiao.jpg";

    /**
     * 添加歌曲
     *
     * @param mpFile 歌曲文件
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 10:02
     **/
    @RequestMapping(value = "/song/add", method = RequestMethod.POST)
    public RestResponse addSong(HttpServletRequest req, @RequestParam("file") MultipartFile mpFile) {
        if (mpFile.isEmpty()) {
            log.info("音乐上传失败，文件为空");
            return RestResponse.fail("音乐上传失败！");
        }
        String fileName = mpFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + File.separator + "song";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            boolean mkdir = file1.mkdirs();
            if (!mkdir) {
                log.info("音乐上传失败，文件夹创建失败");
                return RestResponse.fail("音乐上传失败！");
            }
        }
        File dest = new File(filePath + File.separator + fileName);
        String storeUrlPath = "/song/" + fileName;
        try {
            Song song = toPojo(req, Song.class);
            mpFile.transferTo(dest);
            song.setCreateTime(new Date());
            song.setUpdateTime(new Date());
            song.setPic(DEFAULT_SONG_PIC_PATH);
            song.setUrl(storeUrlPath);
            boolean res = songService.addSong(song);
            if (res) {
                return RestResponse.success("上传成功", storeUrlPath);
            } else {
                return RestResponse.fail("上传失败");
            }
        } catch (IOException e) {
            log.error("添加歌曲失败", e);
            return RestResponse.fail("上传失败");
        }
    }

    /**
     * 返回所有歌曲
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 10:03
     **/
    @RequestMapping(value = "/song")
    public RestResponse allSong() {
        return RestResponse.success(songService.allSong());
    }

    /**
     * 返回指定歌曲ID的歌曲
     *
     * @param id 歌曲id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 13:59
     **/
    @RequestMapping(value = "/song/detail")
    public RestResponse songOfId(Integer id) {
        return RestResponse.success(songService.songOfId(id));
    }

    /**
     * 返回指定歌手ID的歌曲
     *
     * @param singerId 歌手id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 13:59
     **/
    @RequestMapping(value = "/song/singer/detail")
    public RestResponse songOfSingerId(Integer singerId) {
        return RestResponse.success(songService.songOfSingerId(singerId));
    }

    /**
     * 返回指定歌手名的歌曲
     *
     * @param name 歌手名
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 13:59
     **/
    @RequestMapping(value = "/song/singerName/detail")
    public RestResponse songOfSingerName(String name) {
        return RestResponse.success(songService.songOfSingerName(name));
    }

    /**
     * 返回指定歌曲名的歌曲
     *
     * @param name 歌曲名
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:00
     **/
    @RequestMapping(value = "/song/name/detail")
    public RestResponse songOfName(String name) {
        return RestResponse.success(songService.songOfName(name));
    }

    /**
     * 删除歌曲
     *
     * @param id 歌曲id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:00
     **/
    @RequestMapping(value = "/song/delete")
    public RestResponse deleteSong(Integer id) {
        if (songService.deleteSong(id)) {
            return RestResponse.success("删除成功");
        } else {
            return RestResponse.fail("删除失败");
        }
    }

    /**
     * 更新歌曲信息
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:00
     **/
    @RequestMapping(value = "/song/update", method = RequestMethod.POST)
    public RestResponse updateSongMsg(HttpServletRequest req) {
        Song song = toPojo(req, Song.class);
        boolean res = songService.updateSongMsg(song);
        if (res) {
            return RestResponse.success("修改成功");
        } else {
            return RestResponse.fail("修改失败");
        }
    }

    /**
     * 更新歌曲图片
     *
     * @param urlFile 歌曲图片
     * @param id      歌曲id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:03
     **/
    @RequestMapping(value = "/song/img/update", method = RequestMethod.POST)
    public RestResponse updateSongPic(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        if (urlFile.isEmpty()) {
            log.info("音乐图片上传失败，文件为空");
            return RestResponse.fail("上传失败");
        }
        String fileName = System.currentTimeMillis() + urlFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + File.separator + "img" + File.separator + "songPic";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            boolean mkdirs = file1.mkdirs();
            if (!mkdirs) {
                log.info("音乐图片上传失败，文件夹创建失败");
                return RestResponse.fail("上传失败");
            }
        }

        File dest = new File(filePath + File.separator + fileName);
        String storeUrlPath = "/img/songPic/" + fileName;
        try {
            urlFile.transferTo(dest);
            Song song = new Song();
            song.setId(id);
            song.setPic(storeUrlPath);
            boolean res = songService.updateSongPic(song);
            if (res) {
                return RestResponse.success("上传成功", storeUrlPath);
            } else {
                return RestResponse.fail("上传失败");
            }
        } catch (IOException e) {
            log.error("上传失败", e);
            return RestResponse.fail("上传失败");
        }
    }

    /**
     * 更新歌曲URL
     *
     * @param urlFile 歌曲
     * @param id      歌曲id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 14:03
     **/
    @RequestMapping(value = "/song/url/update", method = RequestMethod.POST)
    public RestResponse updateSongUrl(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        if (urlFile.isEmpty()) {
            log.info("音乐上传失败，文件为空");
            return RestResponse.fail("音乐上传失败");
        }
        String fileName = urlFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + File.separator + "song";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            boolean mkdirs = file1.mkdirs();
            if (!mkdirs) {
                log.info("音乐上传失败，文件夹创建失败");
                return RestResponse.fail("音乐上传失败");
            }
        }

        File dest = new File(filePath + File.separator + fileName);
        String storeUrlPath = "/song/" + fileName;
        try {
            urlFile.transferTo(dest);
            Song song = new Song();
            song.setId(id);
            song.setUrl(storeUrlPath);
            boolean res = songService.updateSongUrl(song);
            if (res) {
                return RestResponse.success("上传成功", storeUrlPath);
            } else {
                return RestResponse.fail("上传失败");
            }
        } catch (IOException e) {
            log.error("上传失败", e);
            return RestResponse.fail("上传失败");
        }
    }
}
