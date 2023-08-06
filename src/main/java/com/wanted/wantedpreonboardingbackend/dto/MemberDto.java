package com.wanted.wantedpreonboardingbackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDto {

    private Long memberId;
    private String email;
    private String password;

}
