package com.example.authenticatorservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonPropertyOrder({
    "auth-vivelibre-token",
    "date"
})
public class GetTokenResponse {
  @JsonProperty("auth-vivelibre-token")
  private String token;
  private String date;
}
