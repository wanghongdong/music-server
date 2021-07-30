package com.example.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Date;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.music.dao", "com.example.music.dao.ex"})
public class MusicServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MusicServerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MusicServerApplication.class);
    }

}

