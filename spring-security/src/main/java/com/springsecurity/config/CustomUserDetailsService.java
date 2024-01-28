package com.springsecurity.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springsecurity.entity.UserCredentials;
import com.springsecurity.repository.UserCredentialRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserCredentialRepository userCredentialRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserCredentials> credential = userCredentialRepository.findByName(username);
    return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found with name: " + username));
  }
  
}
