package com.application.cloudo.repository;

import com.application.cloudo.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findRecordByUserOrderByCreatedDateAsc();
}
