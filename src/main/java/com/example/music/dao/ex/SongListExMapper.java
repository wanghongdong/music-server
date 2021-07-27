package com.example.music.dao.ex;

import com.example.music.dao.SongListMapper;
import com.example.music.domain.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SongListExMapper extends SongListMapper {

    List<SongList> allSongList();

    List<SongList> likeTitle(String title);

    List<SongList> likeStyle(String style);

    List<SongList> songListOfTitle(String title);
}
