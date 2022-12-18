package com.application.cloudo.webDto.record.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WebRecordUpdateResponseDto {

    private Long recordId;
    private Long userId;
    private String recordName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime recordDueDate;
    private int recordDone;
    private String recordMemo;

    @Builder
    public WebRecordUpdateResponseDto(Long recordId, Long userId, String recordName, LocalDateTime recordDueDate, int recordDone, String recordMemo) {
        this.recordId = recordId;
        this.userId = userId;
        this.recordName = recordName;
        this.recordDueDate = recordDueDate;
        this.recordDone = recordDone;
        this.recordMemo = recordMemo;
    }

    public static WebRecordUpdateResponseDto from(Long recordId, Long userId, String recordName, LocalDateTime recordDueDate, int recordDone, String recordMemo) {
        return WebRecordUpdateResponseDto.builder()
                .recordId(recordId)
                .userId(userId)
                .recordName(recordName)
                .recordDueDate(recordDueDate)
                .recordDone(recordDone)
                .recordMemo(recordMemo)
                .build();
    }
}
