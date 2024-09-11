package com.api_vendinha.api.infrastructure.repository;

import com.api_vendinha.api.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositório para a entidade Produto.
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByName(String name);

    Optional<Produto> findById(Long id);
}