package com.application.cloudo.service;

import com.application.cloudo.domain.Record;
import com.application.cloudo.domain.User;
import com.application.cloudo.dto.dataForm.RecordGetForm;
import com.application.cloudo.dto.record.RecordDoneResponseDto;
import com.application.cloudo.dto.record.RecordGetResponseDto;
import com.application.cloudo.repository.RecordRepository;
import com.application.cloudo.repository.UserRepository;
import com.application.cloudo.webDto.record.response.WebRecordAddResponseDto;
import com.application.cloudo.webDto.record.response.WebRecordUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public WebRecordUpdateResponseDto updateRecordContent(Long recordId, Long userId, String updatedContent) {
        Optional<Record> foundRecord = recordRepository.findRecordByIdAndByUserId(recordId, userId);
        if (foundRecord.isPresent()) {
            foundRecord.get().setRecordContent(updatedContent);
            recordRepository.save(foundRecord.get());
            return WebRecordUpdateResponseDto.from(foundRecord.get().getId(), foundRecord.get().getUser().getId(), foundRecord.get().getRecordName(), foundRecord.get().getDueDate(), foundRecord.get().getRecordDone(), foundRecord.get().getContent());
        } else return WebRecordUpdateResponseDto.from(0L, 0L, "not found", LocalDateTime.now(), 0, "not found");
    }

    @Transactional
    public WebRecordAddResponseDto addRecordByUserName(Long userId, String recordName, String content, LocalDateTime dueDate) {
        String userName = userRepository.findUserNameById(userId);
        Optional<User> foundUser = userRepository.findUserByName(userName);
        if (foundUser.isPresent()) {
            Record createdRecord = Record.builder()
                    .user(foundUser.get())
                    .name(recordName)
                    .content(content)
                    .recordDueDate(dueDate)
                    .build();
            foundUser.get().addRecord(createdRecord);
            userRepository.save(foundUser.get());
            recordRepository.save(createdRecord);
            return WebRecordAddResponseDto.from(createdRecord.getId(), createdRecord.getRecordName(), createdRecord.getCreatedDate(), createdRecord.getRecordDone(), createdRecord.getContent());
        } else return WebRecordAddResponseDto.from(0L, "not found", LocalDateTime.now(), 0, "not found");
    }

    @Transactional
    public RecordDoneResponseDto setRecordFinished(String name, Long recordId) {
        Optional<Record> foundRecord = recordRepository.findRecordByIdAndByUserName(recordId, name);
        if (foundRecord.isPresent()) {
            foundRecord.get().setRecordDone();
            recordRepository.save(foundRecord.get());
            return RecordDoneResponseDto.from("Record Finished State Updated");
        } else return RecordDoneResponseDto.from("update failed");
    }

    @Transactional
    public RecordDoneResponseDto setRecordUndone(String name, Long recordId) {
        Optional<Record> foundRecord = recordRepository.findRecordByIdAndByUserName(recordId, name);
        if (foundRecord.isPresent()) {
            Record targetRecord = foundRecord.get();
            targetRecord.setRecordUndone();
            recordRepository.save(targetRecord);
            return RecordDoneResponseDto.from("Record Finished State Updated");
        } else return RecordDoneResponseDto.from("update failed");
    }

    public List<RecordGetForm> getAllRecords(Long userId, String ascOrDesc) {
        List<Record> foundRecords;
        List<RecordGetForm> returnRecords = new ArrayList<>();

        String userName = userRepository.findUserNameById(userId);

        if (ascOrDesc.equals("asc")) {
            foundRecords = recordRepository.findRecordByUserNameOrderByCreatedDateAsc(userName);
            for (Record foundRecord : foundRecords) {
                returnRecords.add(new RecordGetForm(foundRecord.getId(), foundRecord.getUser().getId(), foundRecord.getRecordName(), foundRecord.getCreatedDate(), foundRecord.getDueDate(), foundRecord.getRecordDone(), foundRecord.getContent(), foundRecord.getCategory()));
            }
            return returnRecords;
        } else {
            foundRecords = recordRepository.findRecordByUserNameOrderByCreatedDateDesc(userName);
            for (Record foundRecord : foundRecords) {
                returnRecords.add(new RecordGetForm(foundRecord.getId(), foundRecord.getUser().getId(), foundRecord.getRecordName(), foundRecord.getCreatedDate(), foundRecord.getDueDate(), foundRecord.getRecordDone(), foundRecord.getRecordName(), foundRecord.getCategory()));
            }
            return returnRecords;
        }
    }

    public List<Record> getAllRecordsByCategory(Long userID, String categoryName, String desc) {
        List<Record> foundRecords;
        String userName = userRepository.findUserNameById(userID);

        if (desc.equals("asc")) {
            foundRecords = recordRepository.findRecordByUserNameAndCategoryOrderByCreatedDateAsc(userName, categoryName);
            return foundRecords;
        } else {
            foundRecords = recordRepository.findRecordByUserNameAndCategoryOrderByCreatedDateDesc(userName, categoryName);
            return foundRecords;
        }
    }
}
