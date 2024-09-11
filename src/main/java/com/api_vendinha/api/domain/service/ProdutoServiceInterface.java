package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto;

public interface ProdutoServiceInterface {

    ProdutoResponseDto save(ProdutoRequestDto produtoRequestDto);
    ProdutoResponseDto update(Long id, ProdutoRequestDto produtoRequestDto);
    ProdutoResponseDto getId(Long id);
    ProdutoResponseDto setActive(long id, ProdutoRequestDto produtoRequestDto);
}