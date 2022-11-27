package com.application.cloudo.repository;

import com.application.cloudo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByName(String userName);

    Optional<User> findUserByNameIs(String userName);


}
