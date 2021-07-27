package com.example.music.domain;

import java.io.Serializable;
import java.util.Date;

public class Song implements Serializable {
    /**
     * 主键 id
     */
    private Integer id;

    /**
     * 歌手id singer_id
     */
    private Integer singerId;

    /**
     * 歌曲名称 name
     */
    private String name;

    /**
     * 歌曲简介 introduction
     */
    private String introduction;

    /**
     * 发行时间 create_time
     */
    private Date createTime;

    /**
     * 更新时间 update_time
     */
    private Date updateTime;

    /**
     * 歌曲图片 pic
     */
    private String pic;

    /**
     * 地址 url
     */
    private String url;

    /**
     * 歌词 lyric
     */
    private String lyric;

    /**
     * song
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
     * 歌手id
     * @author wanghongdong
     * @return singer_id 
     */
    public Integer getSingerId() {
        return singerId;
    }

    /**
     * 歌手id
     * @author wanghongdong
     * @param singerId 
     */
    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    /**
     * 歌曲名称
     * @author wanghongdong
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 歌曲名称
     * @author wanghongdong
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 歌曲简介
     * @author wanghongdong
     * @return introduction 
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 歌曲简介
     * @author wanghongdong
     * @param introduction 
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * 发行时间
     * @author wanghongdong
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 发行时间
     * @author wanghongdong
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @author wanghongdong
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @author wanghongdong
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 歌曲图片
     * @author wanghongdong
     * @return pic 
     */
    public String getPic() {
        return pic;
    }

    /**
     * 歌曲图片
     * @author wanghongdong
     * @param pic 
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 地址
     * @author wanghongdong
     * @return url 
     */
    public String getUrl() {
        return url;
    }

    /**
     * 地址
     * @author wanghongdong
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 歌词
     * @author wanghongdong
     * @return lyric 
     */
    public String getLyric() {
        return lyric;
    }

    /**
     * 歌词
     * @author wanghongdong
     * @param lyric 
     */
    public void setLyric(String lyric) {
        this.lyric = lyric == null ? null : lyric.trim();
    }
}