package com.tht.utils;

import lombok.Data;

/**
 * @author tianwei
 * @date 2023/9/18 0018 15:49
 */
@Data
public class R<T> {

    //状态码
    private Integer code;
    //信息
    private String message;
    //数据
    private T data;

    //构造私有化
    private R() { }

    //设置数据,返回对象的方法
    public static<T> R<T> build(T data,Integer code,String message) {
        //创建Result对象，设置值，返回对象
        R<T> r = new R<>();
        //判断返回结果中是否需要数据
        if(data != null) {
            //设置数据到R对象
            r.setData(data);
        }
        //设置其他值
        r.setCode(code);
        r.setMessage(message);
        //返回设置值之后的对象
        return r;
    }


    //设置数据,返回对象的方法
    public static<T> R<T> build(T data,ResultCode resultCode) {
        //创建Result对象，设置值，返回对象
        R<T> r = new R<>();
        //判断返回结果中是否需要数据
        if(data != null) {
            //设置数据到R对象
            r.setData(data);
        }
        //设置其他值
        r.setCode(resultCode.getCode());
        r.setMessage(resultCode.getMessage());
        //返回设置值之后的对象
        return r;
    }

    //成功的方法
    public static<T> R<T> ok(T data) {
        return build(data, ResultCode.SUCCESS);
    }

    //失败的方法
    public static<T> R<T> fail(T data) {
        return build(data,ResultCode.FAIL);
    }

}
