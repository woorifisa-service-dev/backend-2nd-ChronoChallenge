package dev.chrono.chronochallenge.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MessageResponse {

    private String message;

    private int code;

    @Builder
    public MessageResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
