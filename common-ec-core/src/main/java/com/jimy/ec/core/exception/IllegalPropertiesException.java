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
public class IllegalPropertiesException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IllegalPropertiesException() {
        setMessage("Prop is illegal!");
    }

    public IllegalPropertiesException(String message) {
        this.message = message;
        setMessage(String.format("Prop: %s is illegal!", message));
    }
}