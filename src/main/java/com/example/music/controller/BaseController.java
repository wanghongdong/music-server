package com.example.music.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 基类
 *
 * @ClassPath com.example.music.controller
 * @ClassName BaseController
 * @Author whd
 * @Date 2021/7/28 14:21
 * @Version 1.0
 */
public interface BaseController {

    Logger log = LoggerFactory.getLogger(BaseController.class);

    default <T> T toPojo(HttpServletRequest request, Class<T> tClass) {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            T t = tClass.newInstance();
            List<Field> fields = getField(tClass);
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (!"serialVersionUID".equals(fieldName)) {
                    String[] strings = parameterMap.get(fieldName);
                    if (strings != null && strings.length > 0) {
                        Class<?> fieldType = field.getType();
                        if (fieldType.isAssignableFrom(Collection.class) || fieldType.isArray()) {
                            field.set(t, fieldType.cast(strings));

                        } else if (fieldType.isAssignableFrom(String.class)) {
                            field.set(t, strings[0]);
                        } else {
                            try {
                                Method valueOf = fieldType.getMethod("valueOf", String.class);
                                Object value = valueOf.invoke(fieldType, strings[0]);

                                field.set(t, value);
                            } catch (NoSuchMethodException | InvocationTargetException ignored) {
                            }
                        }
                    }
                }
            }
            log.info(JSON.toJSONString(t));
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("request params to Pojo error", e);
        }
        return null;
    }

    static List<Field> getField(Class tempClass) {
        List<Field> fieldList = new ArrayList<>();
        while (tempClass != null) {
            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }
        return fieldList;
    }
}
