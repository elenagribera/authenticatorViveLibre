package com.example.authenticatorservice.service;

import com.example.authenticatorservice.configuration.AuthenticatorViveLibreConfiguration;
import com.example.authenticatorservice.dto.AuthenticationRequest;
import com.example.authenticatorservice.dto.TokenResponse;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
@Service
public class AuthenticationService {
  private final AuthenticatorViveLibreConfiguration authenticatorViveLibreConfiguration;

  public AuthenticationService(AuthenticatorViveLibreConfiguration authenticatorViveLibreConfiguration) {
    this.authenticatorViveLibreConfiguration = authenticatorViveLibreConfiguration;
  }

  public String getTokenFromExternalService() {
    RestTemplate restTemplate = new RestTemplate();
    AuthenticationRequest requestBody = new AuthenticationRequest(authenticatorViveLibreConfiguration.getUsername(), authenticatorViveLibreConfiguration.getPassword());

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<AuthenticationRequest> requestEntity = new HttpEntity<>(requestBody, headers);

    ResponseEntity<TokenResponse> response = restTemplate.postForEntity(
        authenticatorViveLibreConfiguration.getUrl(),
        requestEntity,
        TokenResponse.class
    );

    return response.getBody().getToken();
  }

}
