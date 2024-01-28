package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entity.UserCredentials;
import com.springsecurity.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;
  
  @PostMapping("/register")
  public String addNewUser(@RequestBody UserCredentials user) {
    return authService.saveUser(user);
  }

  @GetMapping("/token")
  public String getToken(UserCredentials userCredentials) {
    return authService.generateToken(userCredentials.getName());
  }

  @GetMapping("/validate")
  public String validateToken(@RequestParam("token") String token) {
    authService.validateToken(token);
    return "Token is valid";
  }

}
