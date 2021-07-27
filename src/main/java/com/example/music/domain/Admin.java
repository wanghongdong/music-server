package com.example.music.domain;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
    /**
     * 主键 id
     */
    private Integer id;

    /**
     * 登录名 name
     */
    private String name;

    /**
     * 密码 password
     */
    private String password;

    /**
     * 创建时间 create_time
     */
    private Date createTime;

    /**
     * admin
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
     * 登录名
     * @author wanghongdong
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 登录名
     * @author wanghongdong
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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