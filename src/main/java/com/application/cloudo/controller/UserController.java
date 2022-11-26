package com.application.cloudo.controller;

import com.application.cloudo.dto.user.UserGetRequestDto;
import com.application.cloudo.dto.user.UserGetResponseDto;
import com.application.cloudo.dto.user.UserJoinRequestDto;
import com.application.cloudo.dto.user.UserJoinResponseDto;
import com.application.cloudo.service.UserService;
import com.application.cloudo.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ApiResponse<UserJoinResponseDto> join(@RequestBody UserJoinRequestDto request) {
        return ApiResponse.success(HttpStatus.OK, userService.addUser(request.getName()));
    }

    @GetMapping("/user")
    public ApiResponse<UserGetResponseDto> get(@RequestBody UserGetRequestDto request) {
        return ApiResponse.success(HttpStatus.OK, userService.findUserByUserName(request.getName()));
    }
}
