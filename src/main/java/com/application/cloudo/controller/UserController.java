package com.application.cloudo.controller;

import com.application.cloudo.dto.dataForm.UserGetAllForm;
import com.application.cloudo.dto.user.UserGetRequestDto;
import com.application.cloudo.dto.user.UserJoinRequestDto;
import com.application.cloudo.dto.user.UserJoinResponseDto;
import com.application.cloudo.service.UserService;
import com.application.cloudo.util.ApiResponse;
import com.application.cloudo.webDto.user.WebUserGetResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
//@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PostMapping("/user/add/")
    public ApiResponse<UserJoinResponseDto> join(@RequestBody UserJoinRequestDto request) {
        return ApiResponse.success(HttpStatus.OK, userService.addUser(request.getUserName()));
    }

    @PostMapping("/user")
    public ApiResponse<WebUserGetResponseDto> get(@RequestBody UserGetRequestDto request) {
        return ApiResponse.success(HttpStatus.OK, userService.findUserByUserId(request.getUserId()));
    }

//    @PostMapping("/user/all")
//    public ApiResponse<WebUserGetAllResponseDto> getAll() {
//        return ApiResponse.success(HttpStatus.OK, userService.findAllUsers());
//    }

    @PostMapping("/user/all")
    public List<UserGetAllForm> getAll() {
        return userService.findAllUsers();
    }
}
