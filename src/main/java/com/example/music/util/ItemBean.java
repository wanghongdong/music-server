package com.example.music.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassPath com.example.music.util
 * @ClassName ItemBean
 * @Description TODO
 * @Author whd
 * @Date 2021/7/28 15:50
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class ItemBean {

    private Integer index;
    private Object srcObj;
    private Object destObj;

}
