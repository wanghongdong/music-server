package com.example.music.dao;

import com.example.music.domain.ListSong;

public interface ListSongMapper {
    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insert(ListSong record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insertSelective(ListSong record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    ListSong selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKeySelective(ListSong record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKey(ListSong record);
}