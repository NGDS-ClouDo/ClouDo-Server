package com.application.cloudo.dto.record;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecordDoneResponseDto {

    private String finished;

    @Builder
    public RecordDoneResponseDto(String finished) {
        this.finished = finished;
    }

    public static RecordDoneResponseDto from(String finished){
        return RecordDoneResponseDto.builder()
                .finished(finished)
                .build();
    }
}
