package com.example.authenticatorservice.controller;

import com.example.authenticatorservice.service.AuthenticationService;
import com.example.authenticatorservice.dto.GetTokenResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.example.authenticatorservice.helpers.Constants.DATE_FORMAT;

@RestController
public class AuthenticationController {
  private final AuthenticationService authenticationService;

  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @GetMapping("/get-token")
  public GetTokenResponse getToken(){
    final String token = authenticationService.getTokenFromExternalService();
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ENGLISH);
    String formattedDate = date.format(formatter);

    return new GetTokenResponse(token, formattedDate);
  }
}
