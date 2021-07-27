package com.example.music.dao;

import com.example.music.domain.Admin;

public interface AdminMapper {
    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insert(Admin record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int insertSelective(Admin record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    Admin selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     *
     * @mbggenerated 2021-07-26 20:27:17
     */
    int updateByPrimaryKey(Admin record);
}