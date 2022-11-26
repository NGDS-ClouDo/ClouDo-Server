package com.application.cloudo.dto.user;

import com.application.cloudo.domain.User;
import lombok.Builder;

public class UserGetResponseDto {

    private User user;


    @Builder
    public UserGetResponseDto(User user) {
        this.user = user;
    }

    public static UserGetResponseDto from(User user) {
        return UserGetResponseDto.builder()
                .user(user)
                .build();
    }
}
