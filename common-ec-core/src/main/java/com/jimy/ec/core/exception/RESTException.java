package com.jimy.ec.core.exception;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * 〈异常信息〉
 *
 * @author 周金明
 * @create 2019/4/28
 * @since 1.0.0
 */
public class RESTException<T>  implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    public RESTException() {
    }

    public RESTException(Integer code, String message, String url, T data) {
        this.code = code;
        this.message = message;
        this.url = url;
        this.data = data;
    }

    private Integer code;
    private String message;
    private String url;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}