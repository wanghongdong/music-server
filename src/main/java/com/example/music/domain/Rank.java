package com.example.music.domain;

import java.io.Serializable;
import java.util.Date;

public class Rank implements Serializable {
    /**
     * 主键 id
     */
    private Long id;

    /**
     * 歌单id song_list_id
     */
    private Long songListId;

    /**
     * 用户id consumer_id
     */
    private Long consumerId;

    /**
     * 得分 score
     */
    private Integer score;

    /**
     * 创建时间 create_time
     */
    private Date createTime;

    /**
     * rank
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @author wanghongdong
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @author wanghongdong
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 歌单id
     * @author wanghongdong
     * @return song_list_id 
     */
    public Long getSongListId() {
        return songListId;
    }

    /**
     * 歌单id
     * @author wanghongdong
     * @param songListId 
     */
    public void setSongListId(Long songListId) {
        this.songListId = songListId;
    }

    /**
     * 用户id
     * @author wanghongdong
     * @return consumer_id 
     */
    public Long getConsumerId() {
        return consumerId;
    }

    /**
     * 用户id
     * @author wanghongdong
     * @param consumerId 
     */
    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    /**
     * 得分
     * @author wanghongdong
     * @return score 
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 得分
     * @author wanghongdong
     * @param score 
     */
    public void setScore(Integer score) {
        this.score = score;
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