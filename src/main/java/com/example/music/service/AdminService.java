package com.example.music.service;

import com.example.music.domain.Admin;

public interface AdminService {

    boolean verifyPassword(String name, String password);

    Admin queryById(Integer id);
}
