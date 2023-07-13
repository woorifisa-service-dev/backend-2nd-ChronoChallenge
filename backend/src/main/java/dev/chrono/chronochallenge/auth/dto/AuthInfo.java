package dev.chrono.chronochallenge.auth.dto;

import lombok.Getter;

@Getter
public class AuthInfo {
    private Long id;
    private String name;
    private boolean authority;

    public AuthInfo(Long id, String name,boolean authority) {
        this.id = id;
        this.name = name;
        this.authority =authority;
    }
}
