package com.api_vendinha.api.domain.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProdutoRequestDto {

    private String name;
    private String quantidade;
    private String preco;
    private Boolean isActive; // Atualizado para refletir a convenção Java

    public Boolean getIs_active() {
        return null;
    }}