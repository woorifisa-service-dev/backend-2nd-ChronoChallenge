package dev.chrono.chronochallenge.auth.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@ToString
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "아이디를 입력해주세요")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z]*$")
    @Size(min = 1, max = 30)
    private String name;
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @Size(min = 1, max = 20)
    private String password;

    public LoginRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
