package com.example.music.dao.ex;

import com.example.music.dao.SingerMapper;
import com.example.music.domain.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerExMapper extends SingerMapper {

    List<Singer> allSinger();

    List<Singer> singerOfName(String name);

    List<Singer> singerOfSex(Integer sex);
}
