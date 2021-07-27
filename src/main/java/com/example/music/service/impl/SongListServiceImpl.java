package com.example.music.service.impl;

import com.example.music.dao.ex.SongListExMapper;
import com.example.music.domain.SongList;
import com.example.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongListServiceImpl implements SongListService {

    @Autowired
    private SongListExMapper songListMapper;

    @Override
    public boolean updateSongListMsg(SongList songList) {
        return songListMapper.updateByPrimaryKeyWithBLOBs(songList) > 0;
    }

    @Override
    public boolean deleteSongList(Integer id) {
        return songListMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<SongList> allSongList() {
        return songListMapper.allSongList();
    }

    @Override
    public List<SongList> likeTitle(String title) {
        return songListMapper.likeTitle(title);
    }

    @Override
    public List<SongList> likeStyle(String style) {
        return songListMapper.likeStyle(style);
    }

    @Override
    public List<SongList> songListOfTitle(String title) {
        return songListMapper.songListOfTitle(title);
    }

    @Override
    public boolean addSongList(SongList songList) {
        return songListMapper.insertSelective(songList) > 0;
    }

    @Override
    public boolean updateSongListImg(SongList songList) {

        return songListMapper.updateByPrimaryKeySelective(songList) > 0;
    }
}
