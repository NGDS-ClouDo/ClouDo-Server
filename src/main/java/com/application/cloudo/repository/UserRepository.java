package com.application.cloudo.repository;

import com.application.cloudo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByName(String userName);

    Optional<User> findUserByNameIs(String userName);

    @Query("select u.name from User u where u.id = :userId")
    String findUserNameById(
            @Param("userId") Long userId
    );

    List<User> findAll();
}
