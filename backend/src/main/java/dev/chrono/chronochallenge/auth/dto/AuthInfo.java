package dev.chrono.chronochallenge.auth.dto;

import lombok.Getter;

@Getter
public class AuthInfo {
    private Long id;
    private String name;

    public AuthInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
