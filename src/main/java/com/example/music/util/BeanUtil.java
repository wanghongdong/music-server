package com.example.music.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassPath com.example.music.util
 * @ClassName BeanUtil
 * @Author whd
 * @Date 2021/7/28 15:47
 * @Version 1.0
 */
@Slf4j
public class BeanUtil {

    public static void copyProperties(Object src, Object dest) {
        if (src != null && dest != null) {
            try {
                BeanUtils.copyProperties(src, dest);
            } catch (Exception e) {
                log.error("copyProperties error", e);
            }

        }
    }

    public static <T> T copyObject(Object src, Class<T> destClass) {
        if (src == null) {
            return null;
        } else {
            try {
                T destObj = destClass.newInstance();
                BeanUtils.copyProperties(src, destObj);
                return destObj;
            } catch (Exception e) {
                log.error("convertObject error", e);
                return null;
            }
        }
    }

    public static <T> List<T> copyList(List<Object> srcList, Class<T> destClass) {
        if (srcList == null || srcList.size() == 0) {
            return new ArrayList<>(1);
        } else {
            try {
                int i;
                if (srcList.size() <= 1000) {
                    ArrayList<T> wrapperList = new ArrayList<>(srcList.size() + 10);
                    for (i = 0; i < srcList.size(); ++i) {
                        Object srcObj = srcList.get(i);
                        T destObj = destClass.newInstance();
                        BeanUtils.copyProperties(srcObj, destObj);
                        wrapperList.add(destObj);
                    }
                    return wrapperList;
                } else {
                    return getStream(srcList, destClass).collect(Collectors.toList());
                }
            } catch (Exception e) {
                log.error("copyList error", e);
                return null;
            }
        }
    }

    public static <T> Set<T> copySet(Set<Object> srcSet, Class<T> destClass) {
        if (srcSet == null || srcSet.size() == 0) {
            return new HashSet<>();
        } else {
            try {
                if (srcSet.size() > 1000) {
                    return getStream(srcSet, destClass).collect(Collectors.toSet());
                } else {
                    return srcSet.stream().filter(Objects::nonNull).map(srcObj->{
                        try {
                            T destObj = destClass.newInstance();
                            BeanUtils.copyProperties(srcObj, destObj);
                            return destObj;
                        } catch (InstantiationException | IllegalAccessException ignored) {
                        }
                        return null;
                    }).filter(Objects::nonNull).collect(Collectors.toSet());
                }
            } catch (Exception var6) {
                log.error("copySet error", var6);
                return null;
            }
        }
    }

    public static void copyPropertiesWithoutNullValue(Object src, Object dest) {
        if (src == null || dest == null) {
            return;
        }
        Field[] declaredFields = src.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            if ("serialVersionUID".equals(fieldName)) {
                return;
            }
            Field fieldOfDest = null;
            try {
                fieldOfDest = dest.getClass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException | SecurityException ignored) {
            }

            if (fieldOfDest != null) {
                fieldOfDest.setAccessible(true);
                Class<?> fieldTypeOfSrc = field.getType();
                if (!fieldTypeOfSrc.isPrimitive() && !fieldTypeOfSrc.isSynthetic()) {
                    Class<?> fieldTypeOfDest = fieldOfDest.getType();
                    if (fieldTypeOfSrc.equals(fieldTypeOfDest)) {
                        try {
                            Object value = field.get(src);
                            if (value != null) {
                                fieldOfDest.set(dest, value);
                            }
                        } catch (IllegalArgumentException | IllegalAccessException ignored) {
                        }
                    }
                }
            }
        }
    }

    public static <T> List<List<T>> splitList(List<T> srcList, int sublistSize) {
        if (srcList != null && !srcList.isEmpty()) {
            int SubListSize = sublistSize;
            if (sublistSize <= 0) {
                SubListSize = srcList.size();
            }

            int loopTotalCnt = srcList.size() % SubListSize == 0 ? srcList.size() / SubListSize : srcList.size() / SubListSize + 1;
            List<List<T>> splitList = new ArrayList<>(loopTotalCnt);

            for (int loopCnt = 0; loopCnt < loopTotalCnt; ++loopCnt) {
                int fromIndex = SubListSize * loopCnt;
                int toIndex = SubListSize * (loopCnt + 1);
                if (toIndex > srcList.size()) {
                    toIndex = srcList.size();
                }

                splitList.add(srcList.subList(fromIndex, toIndex));
            }

            return splitList;
        } else {
            return new ArrayList<>(1);
        }
    }

    private static <T> Stream<T> getStream(Collection<Object> src, Class<T> destClass){
        return src.parallelStream().filter(Objects::nonNull).map((srcObj) -> {
            try {
                T destObj = destClass.newInstance();
                BeanUtils.copyProperties(srcObj, destObj);
                return destObj;
            } catch (Exception var3) {
                return null;
            }
        }).filter(Objects::nonNull);
    }

}
