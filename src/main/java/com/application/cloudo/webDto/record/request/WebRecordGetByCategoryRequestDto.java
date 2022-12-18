package com.application.cloudo.webDto.record.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WebRecordGetByCategoryRequestDto {
    private Long userID;
    private String categoryName;
    private String range;
    private String searchString;
    private String orderBy;
    private String desc;
    private Long page;
}
