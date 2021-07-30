package com.example.music.controller;

import com.example.music.bean.ConsumerDTO;
import com.example.music.constant.Constants;
import com.example.music.domain.Consumer;
import com.example.music.response.RestResponse;
import com.example.music.service.impl.ConsumerServiceImpl;
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
import java.util.Date;

@RestController
public class ConsumerController implements BaseController {

    @Autowired
    private ConsumerServiceImpl consumerService;

    /**
     * 用户注册
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/28 16:16
     **/
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public RestResponse addUser(HttpServletRequest req) {
        ConsumerDTO dto = toPojo(req, ConsumerDTO.class);
        if (StringUtils.isBlank(dto.getUsername())) {
            return RestResponse.fail("用户名不能为空");
        }
        dto.setBirth(DateUtils.toDate(dto.getBirthStr()));
        dto.setCreateTime(new Date());
        dto.setUpdateTime(new Date());
        boolean res = consumerService.addUser(dto);
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
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/28 16:21
     **/
    @RequestMapping(value = "/user")
    public RestResponse allUser() {
        return RestResponse.success(consumerService.allUser());
    }

    /**
     * 返回指定ID的用户
     *
     * @param id 用户id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:27
     **/
    @RequestMapping(value = "/user/detail")
    public RestResponse userOfId(Integer id) {
        Consumer consumer = consumerService.userOfId(id);
        return RestResponse.success(consumer);
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:27
     **/
    @RequestMapping(value = "/user/delete")
    public RestResponse deleteUser(Integer id) {
        if (consumerService.deleteUser(id)) {
            return RestResponse.success("删除失败");
        } else {
            return RestResponse.fail("删除成功");
        }
    }

    /**
     * 更新用户信息
     *
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:27
     **/
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public RestResponse updateUserMsg(HttpServletRequest req) {
        ConsumerDTO consumer = toPojo(req, ConsumerDTO.class);
        if (StringUtils.isBlank(consumer.getUsername())) {
            return RestResponse.fail("用户名或密码错误");
        }
        consumer.setBirth(DateUtils.toDate(consumer.getBirthStr()));
        consumer.setUpdateTime(new Date());

        if (consumerService.updateUserMsg(consumer)) {
            return RestResponse.success("修改成功");
        } else {
            return RestResponse.fail("修改失败");
        }
    }

    /**
     * 更新用户头像
     *
     * @param avatarFile 用户头像
     * @param id         用户id
     * @return com.example.music.response.RestResponse
     * @author wanghongdong
     * @date 2021/7/29 14:27
     **/
    @RequestMapping(value = "/user/avatar/update", method = RequestMethod.POST)
    public RestResponse updateUserPic(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") int id) {

        if (avatarFile.isEmpty()) {
            return RestResponse.fail("文件上传失败！");
        }
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + File.separator + Constants.IMG_AVATAR_PATH;
        File file1 = new File(filePath);
        if (!file1.exists()) {
            if (!file1.mkdir()) {
                log.info("更新用户头像失败，文件夹未创建");
                return RestResponse.fail("文件上传失败！");
            }
        }
        String storeAvatarPath = Constants.IMG_AVATAR_PATH + File.separator + fileName;
        File dest = new File(filePath + File.separator + fileName);
        try {
            avatarFile.transferTo(dest);
            Consumer consumer = new Consumer();
            consumer.setId(id);
            consumer.setAvatar(storeAvatarPath);
            if (consumerService.updateUserAvatar(consumer)) {
                return RestResponse.success("上传成功", storeAvatarPath);
            } else {
                return RestResponse.fail("上传失败");
            }
        } catch (IOException e) {
            log.error("更新用户头像失败", e);
            return RestResponse.fail("上传失败");
        }
    }
}
