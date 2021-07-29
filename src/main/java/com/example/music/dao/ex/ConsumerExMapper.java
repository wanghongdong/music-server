package com.example.music.dao.ex;

import com.example.music.dao.ConsumerMapper;
import com.example.music.domain.Consumer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerExMapper extends ConsumerMapper {

    int verifyPassword(@Param("username") String username, @Param("password") String password);

    int existUsername(String username);

    List<Consumer> allUser();

    Consumer loginStatus(String username);

}
