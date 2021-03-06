package com.example.music.service.impl;

import com.example.music.dao.ex.RankExMapper;
import com.example.music.domain.Rank;
import com.example.music.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankExMapper rankMapper;

    @Override
    public int rankOfSongListId(Long songListId) {
        return rankMapper.selectSongListRank(songListId);
    }

    @Override
    public boolean addRank(Rank rank) {
        return rankMapper.insertSelective(rank) > 0;
    }

    @Override
    public int getSongListRankByUser(Long songListId, Long consumerId) {
        return rankMapper.selectScoreSum(songListId, consumerId);
    }
}
