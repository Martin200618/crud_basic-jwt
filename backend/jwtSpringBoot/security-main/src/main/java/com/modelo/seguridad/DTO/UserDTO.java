package com.modelo.seguridad.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modelo.seguridad.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO{
    @JsonProperty("id")
    private int userid; 
    private String username;
    private String password;
    private String email;
    private Roles role;
    private boolean enabled;

    // Getters and Setters
}