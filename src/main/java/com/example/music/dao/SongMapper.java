package com.example.music.dao;

import com.example.music.domain.Song;

public interface SongMapper {
    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insert(Song record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insertSelective(Song record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    Song selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKeySelective(Song record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKeyWithBLOBs(Song record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKey(Song record);
}