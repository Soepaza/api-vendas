package com.api_vendinha.api.domain.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data // Gera automaticamente métodos getters, setters, toString, equals e hashCode.
@NoArgsConstructor // Gera um construtor sem argumentos, necessário para a criação de instâncias pelo JPA e outras operações.
public class UserRequestDto {


    private String name;
    private String email;
    private String password;
    private String cpf;
    private String cep;
    private Boolean is_active;

    private List<ProdutoRequestDto> produtoRequestDto;
}
