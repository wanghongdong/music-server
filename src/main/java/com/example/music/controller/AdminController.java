package com.example.music.controller;

import com.example.music.response.RestResponse;
import com.example.music.domain.Admin;
import com.example.music.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController implements BaseController{

    @Autowired
    private AdminServiceImpl adminService;

    //判断是否登录成功
    @RequestMapping(value = "/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session) {
        Admin admin = toPojo(request, Admin.class);
        boolean res = adminService.verifyPassword(admin.getName(), admin.getPassword());
        if (res) {
            session.setAttribute("name", admin.getName());
            return RestResponse.success(null);
        } else {
            return RestResponse.fail("用户名或密码错误");
        }
    }

    @RequestMapping(value = "/queryById")
    public RestResponse queryById(Integer id, HttpSession session) {
        Admin admin = adminService.queryById(id);
        return RestResponse.success(admin);
    }
}
