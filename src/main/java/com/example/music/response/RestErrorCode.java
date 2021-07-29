package com.example.music.response;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 错误码
 *
 * @ClassPath com.example.music.response
 * @ClassName RestErrorCode
 * @Author whd
 * @Date 2021/7/29 09:16
 * @Version 1.0
 */
@Slf4j
public class RestErrorCode {

    private static final Map<Integer, String> CODE_MSG_MAPPINGS = new HashMap<>();

    @ResultMessage("失败")
    public static final int FAIL = 0;
    @ResultMessage("成功")
    public static final int SUCCESS = 1;

    @ResultMessage("已收藏")
    public static final int COLLECTED = 2;

    @ResultMessage("登录已失效，请重新登录")
    public static final int HTTP_UNAUTHORIZED = 401;
    @ResultMessage("禁止访问")
    public static final int HTTP_FORBIDDEN = 403;
    @ResultMessage("资源不存在")
    public static final int HTTP_NOT_FOUND = 404;
    @ResultMessage("请求方法被禁止访问")
    public static final int HTTP_METHOD_NOT_ALLOWED = 405;
    @ResultMessage("系统内部发生错误")
    public static final int HTTP_SYSTEM_ERROR = 500;
    @ResultMessage("请求参数校验不通过")
    public static final int HTTP_PARAM_INVALID = 998;
    @ResultMessage("未知错误")
    public static final int UNKNOWN_ERROR = 999;

    static {
        try {
            Field[] fields = RestErrorCode.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                ResultMessage annotation = field.getAnnotation(ResultMessage.class);
                if (annotation != null) {
                    int resultCode = field.getInt(null);
                    String resultMsg;
                    if (CODE_MSG_MAPPINGS.containsKey(resultCode)) {
                        resultMsg = "定义错误码发生冲突（errorCode=" + resultCode + "），应用进程已经退出，请解决冲突并重启服务！";
                        log.error(resultMsg);
                        System.exit(-1);
                    }
                    resultMsg = annotation.value().trim();
                    if (!"".equals(resultMsg)) {
                        CODE_MSG_MAPPINGS.put(resultCode, resultMsg);
                    }
                }
            }
        } catch (Exception var8) {
            log.error("初始化错误码异常！进程退出！", var8);
            System.exit(-1);
        }

    }

    public static String renderMsg(int errorCode, Object... args) {
        String rawErrorMsg = CODE_MSG_MAPPINGS.get(errorCode);
        return rawErrorMsg == null ? "未知错误" : MessageFormat.format(rawErrorMsg, args);
    }
}
