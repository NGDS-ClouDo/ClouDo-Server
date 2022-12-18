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
    private String recordName;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String category = "";

    private LocalDateTime createdDate;
    private LocalDateTime dueDate;

    private int recordDone;

    @Builder
    public Record(String name, String content, User user, LocalDateTime recordDueDate) {
        this.recordName = name;
        this.content = content;
        this.user = user;
        this.dueDate = recordDueDate;
        this.createdDate = LocalDateTime.now();
        this.recordDone = 0;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRecordContent(String content) {
        this.content = content;
    }

    public void setRecordDone() {
        this.recordDone = 1;
    }

    public void setRecordUndone() {
        this.recordDone = 0;
    }

    public void setCategory(String category){
        this.category = category;
    }
}
