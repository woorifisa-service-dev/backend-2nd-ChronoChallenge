package dev.chrono.chronochallenge.auth.exception;

public class LoginFailedException extends  RuntimeException{
    private static final String MESSAGE = "아이디와 비밀번호가 일치하지 않습니다.";

    public LoginFailedException() {
        super(MESSAGE);
    }
}
