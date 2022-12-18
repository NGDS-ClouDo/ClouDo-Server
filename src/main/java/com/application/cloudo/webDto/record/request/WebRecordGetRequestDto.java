package com.application.cloudo.webDto.record.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WebRecordGetRequestDto {
    private Long userID;
    private String doneOrNot;
    private String searchString;
    private String orderBy;
    private String desc;
    private Long page;
}
