package com.modelo.seguridad.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modelo.seguridad.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recovery_requestDTO {
    @JsonProperty("id")
     private int recovery_requestid;
    private String email;
    private String token;
    private long expirationTime;
    private Users user;

    // Getters and Setters
}