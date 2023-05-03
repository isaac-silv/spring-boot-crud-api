package com.estudos.spring.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.spring.model.User;

public interface UserDB extends JpaRepository<User, Long> {
}
