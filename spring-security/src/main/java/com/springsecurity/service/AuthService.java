package com.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.UserCredentials;
import com.springsecurity.repository.UserCredentialRepository;

@Service
public class AuthService {

  @Autowired
  private UserCredentialRepository userCredentialRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtService jwtService;
  
  public String saveUser(UserCredentials userCredentials) {
    userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
    userCredentialRepository.save(userCredentials);
    return "User added to the system";
  }

  public String generateToken(String username) {
    return jwtService.generateToken(username);
  }

  public void validateToken(String token) {
    jwtService.validateToken(token);
  }

}
