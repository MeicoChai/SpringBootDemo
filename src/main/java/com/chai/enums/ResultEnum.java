package com.chai.enums;

/**
 * @Author: minquan.chai@hand-china.com
 * @Modificd By:
 * @Date: Created in chai on 2018/9/27.
 */

public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你应该还是再读小学吧"),
    MIDDLE_SCHOOL(101,"你应该还是再读初中吧"),
    ;

    /**异常码.*/
    private Integer code;

    /**异常信息.*/
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
