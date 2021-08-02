package com.example.music.service;

import com.example.music.domain.Rank;

public interface RankService {

    int rankOfSongListId(Long songListId);

    boolean addRank(Rank rank);

    int getSongListRankByUser(Long songListId, Long consumerId);
}
