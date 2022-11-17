package com.application.cloudo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class Record {

    @Id
    private Long recordId;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;

    private int finished;

    public Record(Long recordId, String content, User user, LocalDateTime dueDate) {
        this.recordId = recordId;
        this.content = content;
        this.user = user;
        this.createdDate = LocalDateTime.now();
        this.dueDate = dueDate;
        this.finished = 0;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
