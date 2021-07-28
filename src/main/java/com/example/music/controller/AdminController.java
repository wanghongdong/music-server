package com.example.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.music.domain.Admin;
import com.example.music.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    //判断是否登录成功
    @RequestMapping(value = "/login/status", method = RequestMethod.POST)
    public Object loginStatus(String name, String password, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        boolean res = adminService.verifyPassword(name, password);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "登录成功");
            session.setAttribute("name", name);
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
        }
        return jsonObject;

    }

    @RequestMapping(value = "/queryById")
    public Object queryById(Integer id, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        Admin admin = adminService.queryById(id);
        jsonObject.put("code", 1);
        jsonObject.put("msg", "登录成功");
        jsonObject.put("data", admin);
        return jsonObject;
    }
}
