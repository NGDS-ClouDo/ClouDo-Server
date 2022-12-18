package com.application.cloudo.webDto.record.response;

import com.application.cloudo.domain.Record;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class WebRecordGetResponseDto {

    private List<Record> records;

    @Builder
    public WebRecordGetResponseDto(List<Record> records) {
        this.records = records;
    }

    public static WebRecordGetResponseDto from(List<Record> records) {
        return WebRecordGetResponseDto.builder()
                .records(records)
                .build();
    }
}
