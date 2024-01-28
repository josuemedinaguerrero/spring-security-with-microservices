package com.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.entity.UserCredentials;

public interface UserCredentialRepository extends JpaRepository<UserCredentials, Integer> {
  
  Optional<UserCredentials> findByName(String username);

}
