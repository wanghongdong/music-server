package com.example.music.service.impl;

import com.example.music.dao.ex.SingerExMapper;
import com.example.music.domain.Singer;
import com.example.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerExMapper singerMapper;

    @Override
    public boolean updateSingerMsg(Singer singer) {
        return singerMapper.updateByPrimaryKeySelective(singer) > 0;
    }

    @Override
    public boolean updateSingerPic(Singer singer) {

        return singerMapper.updateByPrimaryKeySelective(singer) > 0;
    }

    @Override
    public boolean deleteSinger(Integer id) {
        return singerMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Singer> allSinger() {
        return singerMapper.allSinger();
    }

    @Override
    public boolean addSinger(Singer singer) {

        return singerMapper.insertSelective(singer) > 0;
    }

    @Override
    public List<Singer> singerOfName(String name) {
        return singerMapper.singerOfName(name);
    }

    @Override
    public List<Singer> singerOfSex(Integer sex) {
        return singerMapper.singerOfSex(sex);
    }
}
