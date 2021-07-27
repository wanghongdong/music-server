package com.example.music.dao.ex;

import com.example.music.dao.ListSongMapper;
import com.example.music.domain.ListSong;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListSongExMapper extends ListSongMapper {

    int deleteListSong(Integer songId);

    List<ListSong> allListSong();

    List<ListSong> listSongOfSongId(Integer songListId);
}
