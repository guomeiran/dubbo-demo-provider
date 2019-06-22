package com.gmr.dubbo.provider.remote.enums;

import lombok.Getter;


public enum CodeEnum {
    SUCCESS(20000, "success"),
    FAILED(40000, "failed"),
    ERROR(50000, "error");

    CodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Getter
    private Integer code;

    @Getter
    private String desc;
}
