package com.wanted.wantedpreonboardingbackend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponse {
    private Long id;
    private String email;
    private String password;
}
