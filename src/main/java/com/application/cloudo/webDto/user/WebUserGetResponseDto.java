package com.application.cloudo.webDto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WebUserGetResponseDto {
    private Long userId;
    private String userName;

    @Builder
    public WebUserGetResponseDto(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public static WebUserGetResponseDto from(Long userId, String userName) {
        return WebUserGetResponseDto.builder()
                .userId(userId)
                .userName(userName)
                .build();
    }
}
