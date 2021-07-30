package com.example.music.controller;

import com.example.music.domain.ListSong;
import com.example.music.response.RestResponse;
import com.example.music.service.impl.ListSongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ListSongController implements BaseController {

    @Autowired
    private ListSongServiceImpl listSongService;

    /**
     * 给歌单添加歌曲
     *
     * @param songId     歌曲id
     * @param songListId 歌单id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 17:04
     **/
    @RequestMapping(value = "/ListSong/add", method = RequestMethod.POST)
    public RestResponse addListSong(Integer songId, Integer songListId) {
        ListSong listSong = new ListSong();
        listSong.setSongId(songId);
        listSong.setSongListId(songListId);

        if (listSongService.addListSong(listSong)) {
            return RestResponse.success("添加成功");
        } else {
            return RestResponse.fail("添加失败");
        }
    }

    /**
     * 返回歌单里包含的所有歌曲
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 17:06
     **/
    @RequestMapping(value = "/listSong", method = RequestMethod.GET)
    public RestResponse allListSong() {
        return RestResponse.success(listSongService.allListSong());
    }

    /**
     * 返回歌单里指定歌单ID的歌曲
     *
     * @param songListId 歌单id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 08:50
     **/
    @RequestMapping(value = "/listSong/detail", method = RequestMethod.GET)
    public RestResponse listSongOfSongId(Integer songListId) {
        return RestResponse.success(listSongService.listSongOfSongId(songListId));
    }

    /**
     * 删除歌单里的歌曲
     *
     * @param songId 歌曲id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 08:50
     **/
    @RequestMapping(value = "/ListSong/delete", method = RequestMethod.GET)
    public RestResponse deleteListSong(Integer songId) {
        return RestResponse.success(listSongService.deleteListSong(songId));
    }

    /**
     * 更新歌单里面的歌曲信息
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 08:52
     **/
    @RequestMapping(value = "/listSong/update", method = RequestMethod.POST)
    public RestResponse updateListSongMsg(HttpServletRequest req) {
        ListSong listSong = toPojo(req, ListSong.class);
        if (listSongService.updateListSongMsg(listSong)) {
            return RestResponse.success("修改成功");
        } else {
            return RestResponse.fail("修改失败");
        }
    }
}
