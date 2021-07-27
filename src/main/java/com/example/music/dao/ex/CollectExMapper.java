package com.example.music.dao.ex;

import com.example.music.dao.CollectMapper;
import com.example.music.domain.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectExMapper extends CollectMapper {

    int existSongId(@Param("userId") Integer userId, @Param("songId") Integer songId);

    int deleteCollect(@Param("userId") Integer userId, @Param("songId") Integer songId);

    List<Collect> allCollect();

    List<Collect> collectionOfUser(Integer userId);
}
