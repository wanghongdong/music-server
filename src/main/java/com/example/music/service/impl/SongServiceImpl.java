package com.example.music.service.impl;

import com.example.music.dao.ex.SongExMapper;
import com.example.music.domain.Song;
import com.example.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongExMapper songMapper;

    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }

    @Override
    public boolean addSong(Song song) {

        return songMapper.insertSelective(song) > 0;
    }

    @Override
    public boolean updateSongMsg(Song song) {
        return songMapper.updateByPrimaryKeyWithBLOBs(song) > 0;
    }

    @Override
    public boolean updateSongUrl(Song song) {

        return songMapper.updateByPrimaryKeySelective(song) > 0;
    }

    @Override
    public boolean updateSongPic(Song song) {

        return songMapper.updateByPrimaryKeySelective(song) > 0;
    }

    @Override
    public boolean deleteSong(Integer id) {
        return songMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Song> songOfSingerId(Integer singerId) {
        return songMapper.songOfSingerId(singerId);
    }

    @Override
    public Song songOfId(Integer id) {
        return songMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Song> songOfSingerName(String name) {
        return songMapper.songOfSingerName(name);
    }

    @Override
    public List<Song> songOfName(String name) {
        return songMapper.songOfName(name);
    }
}
