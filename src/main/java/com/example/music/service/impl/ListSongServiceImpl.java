package com.example.music.service.impl;

import com.example.music.dao.ex.ListSongExMapper;
import com.example.music.domain.ListSong;
import com.example.music.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSongServiceImpl implements ListSongService {

    @Autowired
    private ListSongExMapper listSongMapper;

    @Override
    public List<ListSong> allListSong() {
        return listSongMapper.allListSong();
    }

    @Override
    public boolean updateListSongMsg(ListSong listSong) {
        return listSongMapper.updateByPrimaryKeySelective(listSong) > 0;
    }

    @Override
    public boolean deleteListSong(Integer songId) {
        return listSongMapper.deleteListSong(songId) > 0;
    }

    @Override
    public boolean addListSong(ListSong listSong) {
        return listSongMapper.insertSelective(listSong) > 0;
    }

    @Override
    public List<ListSong> listSongOfSongId(Integer songListId) {
        return listSongMapper.listSongOfSongId(songListId);
    }

}
