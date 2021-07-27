package com.example.music.service;

import com.example.music.domain.Consumer;

import java.util.List;

public interface ConsumerService {

    boolean addUser(Consumer consumer);

    boolean updateUserMsg(Consumer consumer);

    boolean updateUserAvatar(Consumer consumer);

    boolean existUser(String username);

    boolean verifyPassword(String username, String password);

    boolean deleteUser(Integer id);

    List<Consumer> allUser();

    Consumer userOfId(Integer id);

    List<Consumer> loginStatus(String username);

}
