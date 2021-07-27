package com.example.music.domain;

import java.io.Serializable;
import java.util.Date;

public class Consumer implements Serializable {
    /**
     * 主键 id
     */
    private Integer id;

    /**
     * 用户名 username
     */
    private String username;

    /**
     * 密码 password
     */
    private String password;

    /**
     * 性别，0：女，1：男 sex
     */
    private Byte sex;

    /**
     * 手机号 phone_num
     */
    private String phoneNum;

    /**
     * 邮箱 email
     */
    private String email;

    /**
     * 生日 birth
     */
    private Date birth;

    /**
     * 签名 introduction
     */
    private String introduction;

    /**
     * 地址 location
     */
    private String location;

    /**
     * 头像 avatar
     */
    private String avatar;

    /**
     * 创建时间 create_time
     */
    private Date createTime;

    /**
     * 更新时间 update_time
     */
    private Date updateTime;

    /**
     * consumer
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
     * 用户名
     * @author wanghongdong
     * @return username 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @author wanghongdong
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     * @author wanghongdong
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @author wanghongdong
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
     * 手机号
     * @author wanghongdong
     * @return phone_num 
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 手机号
     * @author wanghongdong
     * @param phoneNum 
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    /**
     * 邮箱
     * @author wanghongdong
     * @return email 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @author wanghongdong
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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
     * 签名
     * @author wanghongdong
     * @return introduction 
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 签名
     * @author wanghongdong
     * @param introduction 
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
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
     * 头像
     * @author wanghongdong
     * @return avatar 
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 头像
     * @author wanghongdong
     * @param avatar 
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
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
}