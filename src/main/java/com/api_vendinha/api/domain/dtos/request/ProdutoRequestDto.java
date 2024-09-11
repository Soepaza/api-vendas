package com.api_vendinha.api.domain.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para representar os dados necessários para criar ou atualizar um produto.
 */
@Data
@NoArgsConstructor
public class ProdutoRequestDto {

    private String name;
    private String quantidade;
    private String preco;
    private Boolean isActive; // Atualizado para refletir a convenção Java

    // Se precisar de um método getIs_active, você pode implementá-lo assim:
    public Boolean getIs_active() {
        return isActive;
    }

    // No entanto, o método getIsActive() é mais comum e recomendado:
    public Boolean getIsActive() {
        return isActive;
    }
}