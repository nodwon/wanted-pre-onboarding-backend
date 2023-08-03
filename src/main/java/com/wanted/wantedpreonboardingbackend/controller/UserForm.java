package com.wanted.wantedpreonboardingbackend.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    @NotBlank(message = "유효한 아이디를 입력해주세요.")
    private String id;

    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Email(regexp ="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String email;

    @NotBlank(message = "유효한 비밀번호를 입력해주세요.")
    private String userPassword;

}
