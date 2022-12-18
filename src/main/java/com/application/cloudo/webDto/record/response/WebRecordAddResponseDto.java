package com.application.cloudo.webDto.record.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WebRecordAddResponseDto {
    private Long recordID;
    private String recordName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime recordDueDate;
    private int recordDone;
    private String recordMemo;

    @Builder
    public WebRecordAddResponseDto(Long recordID, String recordName, LocalDateTime recordDueDate, int recordDone, String recordMemo) {
        this.recordID = recordID;
        this.recordName = recordName;
        this.recordDueDate = recordDueDate;
        this.recordDone = recordDone;
        this.recordMemo = recordMemo;
    }

    public static WebRecordAddResponseDto from(Long recordID, String recordName, LocalDateTime recordDueDate, int recordDone, String recordMemo) {
        return WebRecordAddResponseDto.builder()
                .recordID(recordID)
                .recordName(recordName)
                .recordDueDate(recordDueDate)
                .recordDone(recordDone)
                .recordMemo(recordMemo)
                .build();
    }
}
