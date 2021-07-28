package com.example.music.service.impl;

import com.example.music.dao.ex.AdminExMapper;
import com.example.music.domain.Admin;
import com.example.music.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminExMapper adminMapper;

    @Override
    public boolean verifyPassword(String name, String password) {
        return adminMapper.verifyPassword(name, password) > 0;
    }

    @Override
    public Admin queryById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
