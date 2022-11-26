package com.application.cloudo.dto.record;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecordAddResponseDto {

    private String name;

    @Builder
    public RecordAddResponseDto(String name) {
        this.name = name;
    }

    public static RecordAddResponseDto from(String name) {
        return RecordAddResponseDto.builder()
                .name(name)
                .build();
    }
}
