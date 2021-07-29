package com.example.music.service.impl;

import com.example.music.dao.ex.ConsumerExMapper;
import com.example.music.domain.Consumer;
import com.example.music.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerExMapper consumerMapper;

    @Override
    public boolean addUser(Consumer consumer) {
        return consumerMapper.insertSelective(consumer) > 0;
    }

    @Override
    public boolean updateUserMsg(Consumer consumer) {
        return consumerMapper.updateByPrimaryKeySelective(consumer) > 0;
    }

    @Override
    public boolean updateUserAvatar(Consumer consumer) {

        return consumerMapper.updateByPrimaryKeySelective(consumer) > 0;
    }

    @Override
    public boolean existUser(String username) {
        return consumerMapper.existUsername(username) > 0;
    }

    @Override
    public boolean verifyPassword(String username, String password) {
        return consumerMapper.verifyPassword(username, password) > 0;
    }

    //    删除用户
    @Override
    public boolean deleteUser(Integer id) {
        return consumerMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Consumer> allUser() {
        return consumerMapper.allUser();
    }

    @Override
    public Consumer userOfId(Integer id) {
        return consumerMapper.selectByPrimaryKey(id);
    }

    @Override
    public Consumer loginStatus(String username) {
        return consumerMapper.loginStatus(username);
    }
}
