package com.application.cloudo.controller;

import com.application.cloudo.dto.record.RecordAddRequestDto;
import com.application.cloudo.dto.record.RecordAddResponseDto;
import com.application.cloudo.dto.record.RecordGetResponseDto;
import com.application.cloudo.service.RecordService;
import com.application.cloudo.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @GetMapping("/record/{userName}/asc")
    public ApiResponse<RecordGetResponseDto> getRecordByUserNameOrderByAsc(@PathVariable("userName") String userName) {
        return ApiResponse.success(HttpStatus.OK, recordService.findRecordByUserNameOrderByAsc(userName));
    }

    @GetMapping("/record/{userName}/desc")
    public ApiResponse<RecordGetResponseDto> getRecordByUserNameOrderByDesc(@PathVariable("userName") String userName) {
        return ApiResponse.success(HttpStatus.OK, recordService.findRecordByUserNameOrderByDesc(userName));
    }

    @PostMapping("/record/{userName}")
    public ApiResponse<RecordAddResponseDto> addRecord(@PathVariable("userName") String userName, @RequestBody RecordAddRequestDto request) {
        LocalDateTime time = LocalDateTime.now();
//        return ApiResponse.success(HttpStatus.OK, recordService.addRecordByUserName(userName, request.getContent(), request.getRecordDueDate()));
        return ApiResponse.success(HttpStatus.OK, recordService.addRecordByUserName(userName, request.getContent(), time));
    }

}
