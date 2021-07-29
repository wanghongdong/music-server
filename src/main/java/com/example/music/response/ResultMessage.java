package com.example.music.response;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 返回的错误描述
 * @ClassPath com.example.music.response
 * @ClassName ResultMessage
 * @Author whd
 * @Date 2021/7/29 09:17
 * @Version 1.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResultMessage {

    String value() default "";

}
