package com.zhf.exception;

/**
 * @author ZengHongFa
 * @create 2020/2/2 0002 11:45
 */
public class CustomException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomException(){

    }

    public CustomException(String message) {
        this.message = message;
    }
}
