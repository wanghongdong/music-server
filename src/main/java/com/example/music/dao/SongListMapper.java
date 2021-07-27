package com.example.music.dao;

import com.example.music.domain.SongList;

public interface SongListMapper {
    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insert(SongList record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insertSelective(SongList record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    SongList selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKeySelective(SongList record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKeyWithBLOBs(SongList record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKey(SongList record);
}