package com.application.cloudo.service;

import com.application.cloudo.domain.User;
import com.application.cloudo.dto.user.UserGetResponseDto;
import com.application.cloudo.dto.user.UserJoinResponseDto;
import com.application.cloudo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public UserJoinResponseDto addUser(String name) {
        User createdUser = new User(name);
        createdUser.setUserName(name);
        userRepository.save(createdUser);
        return UserJoinResponseDto.from(createdUser);
    }
}
