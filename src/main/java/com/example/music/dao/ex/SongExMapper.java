package com.example.music.dao.ex;

import com.example.music.dao.SongMapper;
import com.example.music.domain.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongExMapper extends SongMapper {

    List<Song> allSong();

    List<Song> songOfSingerId(Integer singerId);

    List<Song> songOfSingerName(String singerName);

    List<Song> songOfName(String name);

}
