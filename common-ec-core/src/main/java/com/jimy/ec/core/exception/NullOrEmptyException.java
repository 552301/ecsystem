package com.jimy.ec.core.exception;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author 周金明
 * @create 2019/4/28
 * @since 1.0.0
 */
public class NullOrEmptyException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NullOrEmptyException() {
        setMessage("Parameter is null or empty!");
    }

    public NullOrEmptyException(String message) {
        this.message = message;
    }
}