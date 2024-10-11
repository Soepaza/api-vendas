package com.api_vendinha.api.domain.dtos.response;

import com.api_vendinha.api.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String cep;
    private Boolean is_active;

}