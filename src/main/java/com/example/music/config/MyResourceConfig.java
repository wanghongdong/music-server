package com.example.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.example.music.constant.Constants.*;

/**
 * 资源文件加载
 *
 * @ClassPath com.example.music.config
 * @ClassName MyPicConfig
 * @Author whd
 * @Date 2021/7/27 5:44 下午
 * @Version 1.0
 */
@Configuration
public class MyResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String projectPath = System.getProperty("user.dir");
        String filePath = String.format("file:%s", projectPath);
        ResourceHandlerRegistration resourceHandler = registry.addResourceHandler("img/**", "song/**");
        resourceHandler.addResourceLocations(filePath + SONG_PATH);
        resourceHandler.addResourceLocations(filePath + IMG_PATH);
        resourceHandler.addResourceLocations(filePath + IMG_AVATAR_PATH);
        resourceHandler.addResourceLocations(filePath + IMG_SINGER_PATH);
        resourceHandler.addResourceLocations(filePath + IMG_SONG_LIST_PATH);
        resourceHandler.addResourceLocations(filePath + IMG_SONG_PATH);

    }
}
