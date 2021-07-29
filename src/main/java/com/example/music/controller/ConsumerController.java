package com.example.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.music.bean.ConsumerDTO;
import com.example.music.response.RestResponse;
import com.example.music.domain.Consumer;
import com.example.music.service.impl.ConsumerServiceImpl;
import com.example.music.util.BeanUtil;
import com.example.music.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ConsumerController implements BaseController {

    @Autowired
    private ConsumerServiceImpl consumerService;

    /**
     * 用户注册
     *
     * @return java.lang.Object
     * @author wanghongdong
     * @date 2021/7/28 16:16
     **/
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public Object addUser(HttpServletRequest req) {
        ConsumerDTO dto = toPojo(req, ConsumerDTO.class);
        if (StringUtils.isBlank(dto.getUsername())) {
            return RestResponse.fail("用户名不能为空");
        }
        dto.setBirth(DateUtils.toDate(dto.getBirthStr()));
        dto.setCreateTime(new Date());
        dto.setUpdateTime(new Date());
        boolean res = consumerService.addUser(BeanUtil.copyObject(dto, Consumer.class));
        if (res) {
            return RestResponse.success("注册成功");
        } else {
            return RestResponse.fail("注册失败");
        }
    }

    /**
     * 判断是否登录成功
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/28 16:18
     **/
    @RequestMapping(value = "/user/login/status", method = RequestMethod.POST)
    public RestResponse loginStatus(String username, String password, HttpSession session) {
        boolean res = consumerService.verifyPassword(username, password);
        if (res) {
            session.setAttribute("username", username);
            return RestResponse.success("登录成功", consumerService.loginStatus(username));
        } else {
            return RestResponse.fail("用户名或密码错误");
        }
    }

    /**
     * 返回所有用户
     * @author wanghongdong
     * @date 2021/7/28 16:21
     * @return java.lang.Object
    **/
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public RestResponse allUser() {
        return RestResponse.success(consumerService.allUser());
    }

    //    返回指定ID的用户
    @RequestMapping(value = "/user/detail", method = RequestMethod.GET)
    public Object userOfId(Integer id) {
        Consumer consumer = consumerService.userOfId(id);
        return RestResponse.success(consumer);
    }

    //    删除用户
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public Object deleteUser(HttpServletRequest req) {
        String id = req.getParameter("id");
        return consumerService.deleteUser(Integer.parseInt(id));
    }

    //    更新用户信息
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Object updateUserMsg(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        String sex = req.getParameter("sex").trim();
        String phone_num = req.getParameter("phone_num").trim();
        String email = req.getParameter("email").trim();
        String birth = req.getParameter("birth").trim();
        String introduction = req.getParameter("introduction").trim();
        String location = req.getParameter("location").trim();
        // String avatar = req.getParameter("avatar").trim();
        // System.out.println(username+"  "+password+"  "+sex+"   "+phone_num+"     "+email+"      "+birth+"       "+introduction+"      "+location);

        if (username.equals("") || username == null) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
            return jsonObject;
        }
        Consumer consumer = new Consumer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        consumer.setId(Integer.parseInt(id));
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        consumer.setPhoneNum(phone_num);
        consumer.setEmail(email);
        consumer.setBirth(myBirth);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        // consumer.setavatar(avatar);
        consumer.setUpdateTime(new Date());

        boolean res = consumerService.updateUserMsg(consumer);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "修改成功");
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "修改失败");
            return jsonObject;
        }
    }

    //    更新用户头像
    @RequestMapping(value = "/user/avatar/update", method = RequestMethod.POST)
    public Object updateUserPic(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") int id) {
        JSONObject jsonObject = new JSONObject();

        if (avatarFile.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "文件上传失败！");
            return jsonObject;
        }
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "avatarImages";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeAvatarPath = "/avatarImages/" + fileName;
        try {
            avatarFile.transferTo(dest);
            Consumer consumer = new Consumer();
            consumer.setId(id);
            consumer.setAvatar(storeAvatarPath);
            boolean res = consumerService.updateUserAvatar(consumer);
            if (res) {
                jsonObject.put("code", 1);
                jsonObject.put("avatar", storeAvatarPath);
                jsonObject.put("msg", "上传成功");
                return jsonObject;
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "上传失败");
                return jsonObject;
            }
        } catch (IOException e) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "上传失败" + e.getMessage());
            return jsonObject;
        } finally {
            return jsonObject;
        }
    }
}
