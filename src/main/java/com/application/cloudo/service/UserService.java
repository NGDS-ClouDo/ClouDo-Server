package com.application.cloudo.service;

import com.application.cloudo.domain.User;
import com.application.cloudo.dto.dataForm.UserGetAllForm;
import com.application.cloudo.dto.user.UserGetResponseDto;
import com.application.cloudo.dto.user.UserJoinResponseDto;
import com.application.cloudo.repository.UserRepository;
import com.application.cloudo.webDto.user.WebUserGetResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserGetResponseDto findUserByUserName(String userName) {
        Optional<User> foundUser = userRepository.findUserByName(userName);
        return UserGetResponseDto.from(foundUser.get());
    }

    public WebUserGetResponseDto findUserByUserId(Long userId) {
        String userName = userRepository.findUserNameById(userId);
        return WebUserGetResponseDto.from(userId, userName);
    }

//    public WebUserGetAllResponseDto findAllUsers() {
//        List<User> users = userRepository.findAll();
//        List<UserGetAllForm> userNames = new ArrayList<>();
//
//        for (User user : users) {
//            userNames.add(new UserGetAllForm(user.getId(), user.getName()));
//        }
//
//        return WebUserGetAllResponseDto.from(userNames);
//    }

    public List<UserGetAllForm> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserGetAllForm> userNames = new ArrayList<>();

        for (User user : users) {
            userNames.add(new UserGetAllForm(user.getId(), user.getName()));
        }

        return userNames;
    }

    @Transactional
    public UserJoinResponseDto addUser(String name) {
        User createdUser = new User(name);
        createdUser.setUserName(name);
        userRepository.save(createdUser);
        return UserJoinResponseDto.from(createdUser);
    }
}
