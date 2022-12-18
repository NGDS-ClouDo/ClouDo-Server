package com.application.cloudo.webDto.record.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WebRecordAddRequestDto {

    private Long userID;
    private String recordName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime recordDueDate;

    private Integer recordDone;
    private String recordMemo;

}
