package com.example.music.bean;

import com.example.music.domain.Singer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 歌手
 * @ClassPath com.example.music.bean
 * @ClassName SingerDTO
 * @Author whd
 * @Date 2021/7/30 08:58
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SingerDTO extends Singer {

    private String birthStr;

}
