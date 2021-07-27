package com.example.music.dao;

import com.example.music.domain.Singer;

public interface SingerMapper {
    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insert(Singer record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insertSelective(Singer record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    Singer selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKeySelective(Singer record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKey(Singer record);
}