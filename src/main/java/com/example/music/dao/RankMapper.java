package com.example.music.dao;

import com.example.music.domain.Rank;

public interface RankMapper {
    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insert(Rank record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insertSelective(Rank record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    Rank selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKeySelective(Rank record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKey(Rank record);
}