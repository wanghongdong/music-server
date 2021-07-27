package com.example.music.dao;

import com.example.music.domain.Consumer;

public interface ConsumerMapper {
    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insert(Consumer record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insertSelective(Consumer record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    Consumer selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKeySelective(Consumer record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKey(Consumer record);
}