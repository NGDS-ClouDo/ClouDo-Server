package com.application.cloudo.webDto.record.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WebRecordDeletedRequestDto {
    private Long recordID;
    private Long userID;
}
