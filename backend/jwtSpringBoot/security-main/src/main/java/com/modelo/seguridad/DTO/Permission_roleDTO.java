package com.modelo.seguridad.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modelo.seguridad.model.Pages;
import com.modelo.seguridad.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission_roleDTO {
    @JsonProperty("id")
    private int permission_roleid;
    private Pages page;
    private Roles role;
    private String type;

    // Getters and Setters
}