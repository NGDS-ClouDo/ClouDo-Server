package com.application.cloudo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "record_id")
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;

    private int recordDone;

    @Builder
    public Record(String content, User user, LocalDateTime recordDueDate) {
        this.content = content;
        this.user = user;
        this.dueDate = recordDueDate;
        this.createdDate = LocalDateTime.now();
        this.recordDone = 0;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
