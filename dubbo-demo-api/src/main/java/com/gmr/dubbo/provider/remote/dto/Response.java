package com.gmr.dubbo.provider.remote.dto;

import com.gmr.dubbo.provider.remote.enums.CodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Xavier on 2018/12/3.
 */
@Data
@Accessors(chain = true)
public class Response<T> implements Serializable {

    public static final long serialVersionUID = -19287542623945L;

    /**
     * @see CodeEnum
     */
    private Integer code;

    /**
     * 结果消息
     */
    private String message;

    /**
     * 返回实体
     */
    private T data;

    /**
     * 导致中断的异常
     */
    private Exception ex;

    public static <R> Response<R> success() {
        return new Response<R>().setCode(CodeEnum.SUCCESS.getCode()).setMessage("success");
    }

    public static <R> Response<R> failed() {
        return new Response<R>().setCode(CodeEnum.FAILED.getCode()).setMessage("failed");
    }

    public static <R> Response<R> error(Exception e) {
        return new Response<R>().setEx(e).setCode(CodeEnum.ERROR.getCode()).setMessage("error");
    }
}
