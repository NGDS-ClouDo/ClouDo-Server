package com.application.cloudo.controller;

import com.application.cloudo.dto.record.RecordAddRequestDto;
import com.application.cloudo.dto.record.RecordAddResponseDto;
import com.application.cloudo.dto.record.RecordDoneResponseDto;
import com.application.cloudo.dto.record.RecordGetResponseDto;
import com.application.cloudo.service.RecordService;
import com.application.cloudo.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return ApiResponse.success(HttpStatus.OK, recordService.addRecordByUserName(userName, request.getContent(), request.getRecordDueDate()));
    }

    @PatchMapping("/record/{userName}/{recordId}")
    public ApiResponse<RecordDoneResponseDto> updateRecordFinishedState(@PathVariable("userName") String userName, @PathVariable("recordId") Long recordId) {
        return ApiResponse.success(HttpStatus.OK, recordService.setRecordFinished(userName, recordId));
    }


    @GetMapping("/record/{userName}/finished/asc")
    public ApiResponse<RecordGetResponseDto> getFinishedRecordByUserNameOrderByAsc(@PathVariable("userName") String userName) {
        return ApiResponse.success(HttpStatus.OK, recordService.findFinishedRecordByUserNameOrderByAsc(userName));
    }

    @GetMapping("/record/{userName}/finished/desc")
    public ApiResponse<RecordGetResponseDto> getFinishedRecordByUserNameOrderByDesc(@PathVariable("userName") String userName) {
        return ApiResponse.success(HttpStatus.OK, recordService.findFinishedRecordByUserNameOrderByDesc(userName));
    }
}
