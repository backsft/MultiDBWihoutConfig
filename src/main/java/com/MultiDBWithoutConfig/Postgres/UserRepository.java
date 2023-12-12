package com.MultiDBWithoutConfig.Postgres;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<ChatUser, String> {
    List<ChatUser> findAllByStatus(Status status);
}
