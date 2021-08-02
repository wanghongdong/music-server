package com.example.music.response;

import lombok.Data;

import static com.example.music.response.RestErrorCode.FAIL;
import static com.example.music.response.RestErrorCode.SUCCESS;

/**
 * 响应体
 * @ClassPath com.example.music.bean
 * @ClassName RestResponse
 * @Author whd
 * @Date 2021/7/28 14:40
 * @Version 1.0
 */
@Data
public class RestResponse {

    private int code;

    private String msg;

    private Object data;

    private boolean success;

    public RestResponse(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = code == SUCCESS;
    }

    public static RestResponse success(Object data){
        return new RestResponse(SUCCESS, RestErrorCode.renderMsg(SUCCESS), data);
    }

    public static RestResponse success(String msg, Object data){
        return new RestResponse(SUCCESS, msg, data);
    }

    public static RestResponse success(String msg){
        return new RestResponse(SUCCESS, msg, null);
    }

    public static RestResponse fail(int code, Object... args){
        return new RestResponse(code, RestErrorCode.renderMsg(code, args), null);
    }

    public static RestResponse fail(String msg){
        return new RestResponse(FAIL, msg, null);
    }

}
