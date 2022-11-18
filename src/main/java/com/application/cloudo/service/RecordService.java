package com.application.cloudo.service;

import com.application.cloudo.domain.Record;
import com.application.cloudo.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    public void getRecords() {
        List<Record> testList = recordRepository.findRecordByUserOrderByCreatedDateAsc();
    }
}
