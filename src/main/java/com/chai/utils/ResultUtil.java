package com.chai.utils;

import com.chai.domain.Result;
import com.chai.enums.ResultEnum;

/**
 * @Author: minquan.chai@hand-china.com
 * @Modificd By:
 * @Date: Created in chai on 2018/9/27.
 */
public class ResultUtil {

    public static <T> Result<T> success(T object, ResultEnum resultEnum) {
        Result result = new Result<T>();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null,ResultEnum.SUCCESS);
    }

    public static Result error(Integer code,String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }
}
