package com.example.music.dao.ex;

import com.example.music.dao.AdminMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminExMapper extends AdminMapper {

    int verifyPassword(String username, String password);

}
