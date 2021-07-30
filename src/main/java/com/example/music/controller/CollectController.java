package com.example.music.controller;

import com.example.music.domain.Collect;
import com.example.music.response.RestErrorCode;
import com.example.music.response.RestResponse;
import com.example.music.service.impl.CollectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/collection")
public class CollectController implements BaseController {

    @Autowired
    private CollectServiceImpl collectService;

    /**
     * 添加收藏的歌曲
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 10:25
     **/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addCollection(HttpServletRequest req) {
        Collect collect = this.toPojo(req, Collect.class);
        collect.setCreateTime(new Date());
        if (collect.getSongId() == null) {
            return RestResponse.fail("收藏歌曲为空");
        } else {
            boolean existSongId = collectService.existSongId(collect.getUserId(), collect.getSongId());
            if (existSongId) {
                return RestResponse.fail(RestErrorCode.COLLECTED);
            }
        }
        boolean res = collectService.addCollection(collect);
        if (res) {
            return RestResponse.success("收藏成功");
        } else {
            return RestResponse.fail("收藏失败");
        }
    }

    /**
     * 返回所有用户收藏列表
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 10:26
     **/
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestResponse allCollection() {
        return RestResponse.success(collectService.allCollect());
    }

    /**
     * 返回的指定用户ID收藏列表
     * @author wanghongdong
     * @date 2021/7/29 10:33
     * @param userId 用户id
     * @return com.example.music.response.RestResponse
    **/
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public RestResponse detail(Integer userId) {
        return RestResponse.success(collectService.collectionOfUser(userId));
    }

    /**
     * 删除收藏的歌曲
     * @author wanghongdong
     * @date 2021/7/29 10:34
     * @param userId 用户id
     * @param songId 歌曲id
     * @return com.example.music.response.RestResponse
    **/
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public RestResponse deleteCollection(Integer userId, Integer songId) {
        boolean deleteCollect = collectService.deleteCollect(userId, songId);
        if (deleteCollect){
            return RestResponse.success(null);
        }else{
            return RestResponse.fail("取消收藏失败");
        }
    }

    /**
     * 更新收藏
     * @author wanghongdong
     * @date 2021/7/29 10:38
     * @return com.example.music.response.RestResponse
    **/
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RestResponse updateCollectMsg(HttpServletRequest req) {
        Collect collect = toPojo(req, Collect.class);
        boolean res = collectService.updateCollectMsg(collect);
        if (res) {
            return RestResponse.success("修改成功");
        } else {
            return RestResponse.fail("修改失败");
        }
    }
}

