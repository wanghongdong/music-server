package com.example.music.controller;

import com.example.music.domain.Rank;
import com.example.music.response.RestResponse;
import com.example.music.service.impl.RankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RankController implements BaseController {

    @Autowired
    private RankServiceImpl rankService;

    /**
     * 提交评分
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 08:55
     **/
    @RequestMapping(value = "/rank/add", method = RequestMethod.POST)
    public RestResponse addRank(HttpServletRequest req) {
        Rank rank = toPojo(req, Rank.class);
        if (rankService.addRank(rank)) {
            return RestResponse.success("评价成功");
        } else {
            return RestResponse.fail("评价失败");
        }
    }

    /**
     * 获取指定歌单的评分
     *
     * @param songListId 歌单id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/30 08:55
     **/
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public RestResponse rankOfSongListId(Long songListId) {
        return RestResponse.success(rankService.rankOfSongListId(songListId));
    }
}
