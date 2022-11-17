package com.application.cloudo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "user_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Record> records = new ArrayList<>();

    public User(Long id, String name, List<Record> records) {
        this.id = id;
        this.name = name;
        this.records = records;
    }

    public void addRecord(Record record) {
        records.add(record);
        record.setUser(this);
    }
}
