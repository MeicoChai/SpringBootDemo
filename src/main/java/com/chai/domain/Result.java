package com.chai.domain;

/**
 * http请求的返回对象
 * @Author: minquan.chai@hand-china.com
 * @Modificd By:
 * @Date: Created in chai on 2018/9/27.
 */
public class Result<T> {

    /** 错误码.*/
    private Integer code;

    /** 返回信息.*/
    private String msg;

    /** 返回对象.*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
