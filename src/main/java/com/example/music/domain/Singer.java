package com.example.music.domain;

import java.io.Serializable;
import java.util.Date;

public class Singer implements Serializable {
    /**
     * 主键 id
     */
    private Integer id;

    /**
     * 姓名 name
     */
    private String name;

    /**
     * 性别，0：女，1：男 sex
     */
    private Byte sex;

    /**
     * 头像图片 pic
     */
    private String pic;

    /**
     * 生日 birth
     */
    private Date birth;

    /**
     * 地址 location
     */
    private String location;

    /**
     * 介绍 introduction
     */
    private String introduction;

    /**
     * singer
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
     * 姓名
     * @author wanghongdong
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @author wanghongdong
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 性别，0：女，1：男
     * @author wanghongdong
     * @return sex 
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 性别，0：女，1：男
     * @author wanghongdong
     * @param sex 
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 头像图片
     * @author wanghongdong
     * @return pic 
     */
    public String getPic() {
        return pic;
    }

    /**
     * 头像图片
     * @author wanghongdong
     * @param pic 
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 生日
     * @author wanghongdong
     * @return birth 
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 生日
     * @author wanghongdong
     * @param birth 
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 地址
     * @author wanghongdong
     * @return location 
     */
    public String getLocation() {
        return location;
    }

    /**
     * 地址
     * @author wanghongdong
     * @param location 
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 介绍
     * @author wanghongdong
     * @return introduction 
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 介绍
     * @author wanghongdong
     * @param introduction 
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}