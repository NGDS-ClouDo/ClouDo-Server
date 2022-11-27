package com.application.cloudo.repository;

import com.application.cloudo.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("select r " +
            "from Record r " +
            "where r.user.name = :name " +
            "order by r.createdDate asc")
    List<Record> findRecordByUserNameOrderByCreatedDateAsc(
            @Param("name") String name
    );

    @Query("select r " +
            "from Record r " +
            "where r.user.name = :name " +
            "order by r.createdDate desc")
    List<Record> findRecordByUserNameOrderByCreatedDateDesc(
            @Param("name") String name
    );

    @Query("select r " +
            "from Record r " +
            "where r.recordDone = 1 " +
            "and r.user.name = :name " +
            "order by r.createdDate asc")
    List<Record> findFinishedRecordByUserNameOrderByCreatedDateAsc(
            @Param("name") String name
    );

    @Query("select r " +
            "from Record r " +
            "where r.recordDone = 1 " +
            "and r.user.name = :name " +
            "order by r.createdDate asc")
    List<Record> findFinishedRecordByUserNameOrderByCreatedDateDesc(
            @Param("name") String name
    );
}
