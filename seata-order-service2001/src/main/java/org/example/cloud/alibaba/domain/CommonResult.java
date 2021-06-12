package org.example.cloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wenqifeng
 * @date 2021/6/7 23:49:44
 */
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

    public static <T> CommonResult<T> instance(Integer code, String message, T data) {
        return new CommonResult(code, message, data);
    }

    public static <T> CommonResult<T> instance(Integer code, String message) {
        return new CommonResult(code, message);
    }
}