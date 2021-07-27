package com.example.music.dao.ex;

import com.example.music.dao.RankMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface RankExMapper extends RankMapper {

    /**
     * 查总分
     * @param songListId
     * @return
     */
    int selectScoreSum(Long songListId);

    /**
     * 查总评分人数
     * @param songListId
     * @return
     */
    int selectRankNum(Long songListId);
}
