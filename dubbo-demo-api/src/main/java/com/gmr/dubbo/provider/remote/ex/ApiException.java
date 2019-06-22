package com.gmr.dubbo.provider.remote.ex;

import com.gmr.dubbo.provider.remote.enums.CodeEnum;
import lombok.Getter;


public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 9238461691457124L;

    @Getter
    private int code = CodeEnum.FAILED.getCode();

    public ApiException() {
        super();
    }

    public ApiException(CodeEnum code) {
        super(code.getDesc());
        this.code = code.getCode();
    }

    public ApiException(CodeEnum code, Throwable cause) {
        super(code.getDesc(), cause);
        this.code = code.getCode();
    }
}
