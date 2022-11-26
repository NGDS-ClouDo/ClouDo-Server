package com.application.cloudo.dto.user;

import com.application.cloudo.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserJoinResponseDto {
    private String name;


    @Builder
    public UserJoinResponseDto(String name) {
        this.name = name;
    }

    public static UserJoinResponseDto from(User user) {
        return UserJoinResponseDto.builder()
                .name(user.getName())
                .build();
    }
}
