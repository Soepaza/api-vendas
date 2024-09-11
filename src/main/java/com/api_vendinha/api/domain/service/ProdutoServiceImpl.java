package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto;
import com.api_vendinha.api.domain.entities.Produto;
import com.api_vendinha.api.infrastructure.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoServiceInterface {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoResponseDto save(ProdutoRequestDto produtoRequestDto) {
        Produto produto = new Produto();
        produto.setName(produtoRequestDto.getName());
        produto.setQuantidade(produtoRequestDto.getQuantidade());
        produto.setPreco(produtoRequestDto.getPreco());
        produto.setIsActive(produtoRequestDto.getIs_active());

        Produto savedProduto = produtoRepository.save(produto);
        return getProdutoResponseDto(savedProduto);
    }

    @Override
    public ProdutoResponseDto update(Long id, ProdutoRequestDto produtoRequestDto) {
        Produto produto = produtoRepository.findById(id).orElseThrow();

        produto.setName(produtoRequestDto.getName());
        produto.setQuantidade(produtoRequestDto.getQuantidade());
        produto.setPreco(produtoRequestDto.getPreco());
        produto.setIsActive(produtoRequestDto.getIs_active());

        produtoRepository.save(produto);
        return getProdutoResponseDto(produto);
    }

    @Override
    public ProdutoResponseDto getId(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        return getProdutoResponseDto(produto);
    }

    @Override
    public ProdutoResponseDto setActive(long id, ProdutoRequestDto produtoRequestDto) {
        Produto produto = produtoRepository.findById(id).orElseThrow();

        produto.setIsActive(produtoRequestDto.getIs_active());
        produtoRepository.save(produto);
        return getProdutoResponseDto(produto);
    }

    private ProdutoResponseDto getProdutoResponseDto(Produto produto) {
        ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto();

        produtoResponseDto.setId(produto.getId()); // Atualizado para refletir o nome correto
        produtoResponseDto.setName(produto.getName());
        produtoResponseDto.setQuantidade(produto.getQuantidade());
        produtoResponseDto.setPreco(produto.getPreco());
        produtoResponseDto.setIs_active(produto.getIsActive()); // Atualizado para refletir o nome correto

        return produtoResponseDto;
    }}
