package com.application.cloudo.dto.dataForm;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserGetAllForm {
    private Long userID;
    private String userName;

    public UserGetAllForm(Long userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }
}
