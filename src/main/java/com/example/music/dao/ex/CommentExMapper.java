package com.example.music.dao.ex;

import com.example.music.dao.CommentMapper;
import com.example.music.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentExMapper extends CommentMapper {

    List<Comment> allComment();

    List<Comment> commentOfSongId(Integer songId);

    List<Comment> commentOfSongListId(Integer songListId);
}
