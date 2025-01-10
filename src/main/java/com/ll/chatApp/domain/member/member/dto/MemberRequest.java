package com.ll.chatApp.domain.member.member.dto;

import lombok.Data;

@Data
public class MemberRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
