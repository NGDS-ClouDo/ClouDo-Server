package com.application.cloudo.dto.dataForm;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class RecordGetForm {
    private Long recordID;
    private Long userID;
    private String recordName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime recordCreatedDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime recordDueDate;
    private int recordDone;
    private String recordMemo;
    private String categoryName;

    public RecordGetForm(Long recordID, Long userID, String recordName, LocalDateTime recordCreatedDate, LocalDateTime recordDueDate, int recordDone, String recordMemo, String categoryName) {
        this.recordID = recordID;
        this.userID = userID;
        this.recordName = recordName;
        this.recordCreatedDate = recordCreatedDate;
        this.recordDueDate = recordDueDate;
        this.recordDone = recordDone;
        this.recordMemo = recordMemo;
        this.categoryName = categoryName;
    }
}
