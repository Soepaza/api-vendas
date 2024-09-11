package com.api_vendinha.api.domain.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoResponseDto {

    private Long id; // Atualizado para refletir a convenção Java
    private String name;
    private String quantidade;
    private String preco;
    private Boolean isActive; // Atualizado para refletir a convenção Java


    public void setIs_active(Boolean isActive) {
    }
}