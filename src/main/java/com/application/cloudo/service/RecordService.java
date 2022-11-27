package com.application.cloudo.service;

import com.application.cloudo.domain.Record;
import com.application.cloudo.domain.User;
import com.application.cloudo.dto.record.RecordAddResponseDto;
import com.application.cloudo.dto.record.RecordGetResponseDto;
import com.application.cloudo.repository.RecordRepository;
import com.application.cloudo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final UserRepository userRepository;

    public RecordGetResponseDto findRecordByUserNameOrderByAsc(String name) {
        List<Record> foundRecord = recordRepository.findRecordByUserNameOrderByCreatedDateAsc(name);

        return RecordGetResponseDto.from(foundRecord);
    }

    public RecordGetResponseDto findRecordByUserNameOrderByDesc(String name) {
        List<Record> foundRecord = recordRepository.findRecordByUserNameOrderByCreatedDateDesc(name);

        return RecordGetResponseDto.from(foundRecord);
    }

    public RecordGetResponseDto findFinishedRecordByUserNameOrderByAsc(String name) {
        List<Record> foundRecord = recordRepository.findFinishedRecordByUserNameOrderByCreatedDateAsc(name);

        return RecordGetResponseDto.from(foundRecord);
    }

    public RecordGetResponseDto findFinishedRecordByUserNameOrderByDesc(String name) {
        List<Record> foundRecord = recordRepository.findFinishedRecordByUserNameOrderByCreatedDateDesc(name);

        return RecordGetResponseDto.from(foundRecord);
    }

    @Transactional
    public RecordAddResponseDto addRecordByUserName(String name, String content, LocalDateTime dueDate) {
        System.out.println("name = " + name);
        Optional<User> foundUser = userRepository.findUserByNameIs(name);
        if (foundUser.isPresent()) {
            Record createdRecord = Record.builder()
                    .user(foundUser.get())
                    .content(content)
                    .recordDueDate(dueDate)
                    .build();
            foundUser.get().addRecord(createdRecord);
            userRepository.save(foundUser.get());
            recordRepository.save(createdRecord);
            return RecordAddResponseDto.from(foundUser.get().getName());
        } else return RecordAddResponseDto.from("not found");
    }
}
