package com.example.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: tanxx
 * @create: 2020-03-12 09:34
 * @description: 统一的客户端返回封装类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static CommonResult ok(String message, Object data) {
        return new CommonResult(200, message, data);
    }

    public static CommonResult error(String message) {
        return new CommonResult(444, message, null);
    }

}
