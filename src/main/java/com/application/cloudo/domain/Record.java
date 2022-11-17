package com.application.cloudo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class Record {

    @Id
    private Long recordId;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;

    private int finished;

    public Record(Long recordId, String content, LocalDateTime dueDate) {
        this.recordId = recordId;
        this.content = content;
        this.createdDate = LocalDateTime.now();
        this.dueDate = dueDate;
        this.finished = 0;
    }
}
