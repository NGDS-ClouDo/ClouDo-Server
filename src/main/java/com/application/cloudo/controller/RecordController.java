package com.application.cloudo.controller;

import com.application.cloudo.domain.Record;
import com.application.cloudo.dto.dataForm.RecordGetForm;
import com.application.cloudo.dto.record.RecordDoneResponseDto;
import com.application.cloudo.dto.record.RecordGetResponseDto;
import com.application.cloudo.service.RecordService;
import com.application.cloudo.util.ApiResponse;
import com.application.cloudo.webDto.record.request.WebRecordAddRequestDto;
import com.application.cloudo.webDto.record.request.WebRecordGetByCategoryRequestDto;
import com.application.cloudo.webDto.record.request.WebRecordGetRequestDto;
import com.application.cloudo.webDto.record.request.WebRecordUpdateRequestDto;
import com.application.cloudo.webDto.record.response.WebRecordAddResponseDto;
import com.application.cloudo.webDto.record.response.WebRecordUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
//@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin
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

//    @PostMapping("/record/{userName}")
//    public ApiResponse<RecordAddResponseDto> addRecord(@PathVariable("userName") String userName, @RequestBody RecordAddRequestDto request) {
//        return ApiResponse.success(HttpStatus.OK, recordService.addRecordByUserName(userName, request.getContent(), request.getRecordDueDate()));
//    }

    @PatchMapping("/record/{userName}/{recordId}/done")
    public ApiResponse<RecordDoneResponseDto> updateRecordFinishedStateDone(@PathVariable("userName") String userName, @PathVariable("recordId") Long recordId) {
        return ApiResponse.success(HttpStatus.OK, recordService.setRecordFinished(userName, recordId));
    }

    @PatchMapping("/record/{userName}/{recordId}/Undone")
    public ApiResponse<RecordDoneResponseDto> updateRecordFinishedStateUndone(@PathVariable("userName") String userName, @PathVariable("recordId") Long recordId) {
        return ApiResponse.success(HttpStatus.OK, recordService.setRecordUndone(userName, recordId));
    }


    @GetMapping("/record/{userName}/finished/asc")
    public ApiResponse<RecordGetResponseDto> getFinishedRecordByUserNameOrderByAsc(@PathVariable("userName") String userName) {
        return ApiResponse.success(HttpStatus.OK, recordService.findFinishedRecordByUserNameOrderByAsc(userName));
    }

    @GetMapping("/record/{userName}/finished/desc")
    public ApiResponse<RecordGetResponseDto> getFinishedRecordByUserNameOrderByDesc(@PathVariable("userName") String userName) {
        return ApiResponse.success(HttpStatus.OK, recordService.findFinishedRecordByUserNameOrderByDesc(userName));
    }


    /////////////////////////////////////////////

    @PostMapping("/record/add")
    public ApiResponse<WebRecordAddResponseDto> addRecord(@RequestBody WebRecordAddRequestDto request) {
        return ApiResponse.success(HttpStatus.OK, recordService.addRecordByUserName(request.getUserID(), request.getRecordName(), request.getRecordMemo(), request.getRecordDueDate()));
    }

    @PostMapping("/record/edit")
    public ApiResponse<WebRecordUpdateResponseDto> updateRecord(@RequestBody WebRecordUpdateRequestDto request) {
        return ApiResponse.success(HttpStatus.OK, recordService.updateRecordContent(request.getRecordID(), request.getUserID(), request.getRecordMemo()));
    }

//    @PostMapping("/record")
//    public ApiResponse<WebRecordGetResponseDto> getAllRecord(@RequestBody WebRecordGetRequestDto request) {
//        return ApiResponse.success(HttpStatus.OK, recordService.getAllRecords(request.getUserID(), request.getDesc()));
//    }
    @PostMapping("/record/")
    public List<RecordGetForm> getAllRecord(@RequestBody WebRecordGetRequestDto request) {
        return recordService.getAllRecords(request.getUserID(), request.getDesc());
    }

    @PostMapping("/record/category/")
    public List<Record> getRecordByCategory(@RequestBody WebRecordGetByCategoryRequestDto requestDto) {
        return recordService.getAllRecordsByCategory(requestDto.getUserID(), requestDto.getCategoryName(), requestDto.getDesc());
    }


}
