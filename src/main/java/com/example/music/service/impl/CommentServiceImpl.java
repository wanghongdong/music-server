package com.example.music.service.impl;

import com.example.music.dao.ex.CommentExMapper;
import com.example.music.domain.Comment;
import com.example.music.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentExMapper commentMapper;

    @Override
    public boolean addComment(Comment comment) {
        return commentMapper.insertSelective(comment) > 0;
    }

    @Override
    public boolean updateCommentMsg(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment) > 0;
    }

    //    删除评论
    @Override
    public boolean deleteComment(Integer id) {
        return commentMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Comment> allComment() {
        return commentMapper.allComment();
    }

    @Override
    public List<Comment> commentOfSongId(Integer songId) {
        return commentMapper.commentOfSongId(songId);
    }

    @Override
    public List<Comment> commentOfSongListId(Integer songListId) {
        return commentMapper.commentOfSongListId(songListId);
    }
}
