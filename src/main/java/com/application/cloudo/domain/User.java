package com.application.cloudo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Record> records = new ArrayList<>();


    @Builder
    public User(String name) {
        this.name = name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public void addRecord(Record record) {
        records.add(record);
        record.setUser(this);
    }
}
