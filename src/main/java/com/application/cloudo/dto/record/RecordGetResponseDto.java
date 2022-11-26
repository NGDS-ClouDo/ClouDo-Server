package com.application.cloudo.dto.record;

import com.application.cloudo.domain.Record;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RecordGetResponseDto {
    private List<Record> records;

    @Builder
    public RecordGetResponseDto(List<Record> records) {
        this.records = records;
    }

    public static RecordGetResponseDto from(List<Record> records) {
        return RecordGetResponseDto.builder()
                .records(records)
                .build();
    }
}
