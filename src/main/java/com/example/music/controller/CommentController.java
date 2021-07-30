package com.example.music.controller;

import com.example.music.domain.Comment;
import com.example.music.response.RestResponse;
import com.example.music.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class CommentController implements BaseController {

    @Autowired
    private CommentServiceImpl commentService;

    /**
     * 提交评论
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:10
     **/
    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public RestResponse addComment(HttpServletRequest req) {
        Comment comment = toPojo(req, Comment.class);
        comment.setCreateTime(new Date());
        boolean res = commentService.addComment(comment);
        if (res) {
            return RestResponse.success("评论成功");
        } else {
            return RestResponse.success("评论失败");
        }
    }

    /**
     * 获取所有评论列表
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:11
     **/
    @RequestMapping(value = "/comment")
    public RestResponse allComment() {
        return RestResponse.success(commentService.allComment());
    }

    /**
     * 获得指定歌曲ID的评论列表
     *
     * @param songId 歌曲ID
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:11
     **/
    @RequestMapping(value = "/comment/song/detail")
    public RestResponse commentOfSongId(Integer songId) {
        return RestResponse.success(commentService.commentOfSongId(songId));
    }

    /**
     * 获得指定歌单ID的评论列表
     *
     * @param songListId 歌单ID
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:12
     **/
    @RequestMapping(value = "/comment/songList/detail")
    public RestResponse commentOfSongListId(Integer songListId) {
        return RestResponse.success(commentService.commentOfSongListId(songListId));
    }

    /**
     * 点赞评论
     *
     * @param id 评论id
     * @param up 赞
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:14
     **/
    @RequestMapping(value = "/comment/like", method = RequestMethod.POST)
    public RestResponse commentOfLike(Integer id, Integer up) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUp(up);
        boolean res = commentService.updateCommentMsg(comment);
        if (res) {
            return RestResponse.success("点赞成功");
        } else {
            return RestResponse.success("点赞失败");
        }
    }

    /**
     * 删除评论
     *
     * @param id 评论id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:14
     **/
    @RequestMapping(value = "/comment/delete")
    public RestResponse deleteComment(Integer id) {
        if (commentService.deleteComment(id)) {
            return RestResponse.success("删除成功");
        } else {
            return RestResponse.fail("删除成功");
        }
    }

    /**
     * 更新评论
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:15
     **/
    @RequestMapping(value = "/comment/update", method = RequestMethod.POST)
    public RestResponse updateCommentMsg(HttpServletRequest req) {
        Comment comment = toPojo(req, Comment.class);
        boolean res = commentService.updateCommentMsg(comment);
        if (res) {
            return RestResponse.success("修改成功");
        } else {
            return RestResponse.success("修改失败");
        }
    }
}
