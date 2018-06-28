package com.haoge.exception;

@SuppressWarnings("serial")
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
