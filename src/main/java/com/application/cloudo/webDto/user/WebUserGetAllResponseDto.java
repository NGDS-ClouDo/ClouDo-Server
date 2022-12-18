package com.application.cloudo.webDto.user;

import com.application.cloudo.dto.dataForm.UserGetAllForm;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class WebUserGetAllResponseDto {

    private List<UserGetAllForm> userList;

    @Builder
    public WebUserGetAllResponseDto(List<UserGetAllForm> userList) {
        this.userList = userList;
    }

    public static WebUserGetAllResponseDto from(List<UserGetAllForm> userList) {
        return WebUserGetAllResponseDto.builder()
                .userList(userList)
                .build();
    }
}
