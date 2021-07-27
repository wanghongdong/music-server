package com.example.music.domain;

import java.io.Serializable;

public class SongList implements Serializable {
    /**
     * 主键 id
     */
    private Integer id;

    /**
     * 歌单主题 title
     */
    private String title;

    /**
     * 歌单图片 pic
     */
    private String pic;

    /**
     * 歌单风格 style
     */
    private String style;

    /**
     * 简介 introduction
     */
    private String introduction;

    /**
     * song_list
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
     * 歌单主题
     * @author wanghongdong
     * @return title 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 歌单主题
     * @author wanghongdong
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 歌单图片
     * @author wanghongdong
     * @return pic 
     */
    public String getPic() {
        return pic;
    }

    /**
     * 歌单图片
     * @author wanghongdong
     * @param pic 
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 歌单风格
     * @author wanghongdong
     * @return style 
     */
    public String getStyle() {
        return style;
    }

    /**
     * 歌单风格
     * @author wanghongdong
     * @param style 
     */
    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    /**
     * 简介
     * @author wanghongdong
     * @return introduction 
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 简介
     * @author wanghongdong
     * @param introduction 
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}