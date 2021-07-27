package com.example.music.service.impl;

import com.example.music.dao.ex.CollectExMapper;
import com.example.music.domain.Collect;
import com.example.music.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectExMapper collectExMapper;

    @Override
    public boolean addCollection(Collect collect) {
        return collectExMapper.insertSelective(collect) > 0;
    }

    @Override
    public boolean existSongId(Integer userId, Integer songId) {
        return collectExMapper.existSongId(userId, songId) > 0;
    }

    @Override
    public boolean updateCollectMsg(Collect collect) {
        return collectExMapper.updateByPrimaryKeySelective(collect) > 0;
    }

    @Override
    public boolean deleteCollect(Integer userId, Integer songId) {
        return collectExMapper.deleteCollect(userId, songId) > 0;
    }

    @Override
    public List<Collect> allCollect()

    {
        return collectExMapper.allCollect();
    }

    @Override
    public List<Collect> collectionOfUser(Integer userId)

    {
        return collectExMapper.collectionOfUser(userId);
    }
}
