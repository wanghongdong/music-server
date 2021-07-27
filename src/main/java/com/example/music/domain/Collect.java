package com.example.music.domain;

import java.io.Serializable;
import java.util.Date;

public class Collect implements Serializable {
    /**
     * 主键 id
     */
    private Integer id;

    /**
     * 用户id user_id
     */
    private Integer userId;

    /**
     * 类型，0：歌曲，1：歌单 type
     */
    private Byte type;

    /**
     * 歌曲id song_id
     */
    private Integer songId;

    /**
     * 歌单id song_list_id
     */
    private Integer songListId;

    /**
     * 创建时间 create_time
     */
    private Date createTime;

    /**
     * collect
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @author wanghongdong
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @author wanghongdong
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户id
     * @author wanghongdong
     * @return user_id 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @author wanghongdong
     * @param userId 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 类型，0：歌曲，1：歌单
     * @author wanghongdong
     * @return type 
     */
    public Byte getType() {
        return type;
    }

    /**
     * 类型，0：歌曲，1：歌单
     * @author wanghongdong
     * @param type 
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 歌曲id
     * @author wanghongdong
     * @return song_id 
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * 歌曲id
     * @author wanghongdong
     * @param songId 
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    /**
     * 歌单id
     * @author wanghongdong
     * @return song_list_id 
     */
    public Integer getSongListId() {
        return songListId;
    }

    /**
     * 歌单id
     * @author wanghongdong
     * @param songListId 
     */
    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
    }

    /**
     * 创建时间
     * @author wanghongdong
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @author wanghongdong
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}