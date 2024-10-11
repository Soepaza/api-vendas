package com.api_vendinha.api.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidade representando um usuário no sistema.
 *
 * Esta classe é mapeada para a tabela "users" no banco de dados e representa a estrutura dos dados
 * relacionados a um usuário.
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor // Gera um construtor que aceita argumentos para todos os campos, útil para criar instâncias com todos os dados.
@Data // Gera automaticamente métodos getters, setters, toString, equals e hashCode.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String cep;

    @Column
    private Boolean is_active;

    @OneToMany(mappedBy = "user")
    private List<Produto> produtos;

}
