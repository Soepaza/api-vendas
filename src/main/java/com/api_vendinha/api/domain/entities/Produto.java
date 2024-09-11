package com.api_vendinha.api.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade representando um produto no sistema.
 */
@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Renomeado para seguir a convenção Java

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String quantidade;

    @Column(nullable = false)
    private String preco;

    @Column
    private Boolean isActive; // Renomeado para seguir a convenção Java
}