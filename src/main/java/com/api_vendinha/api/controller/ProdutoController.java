package com.api_vendinha.api.controller;

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto;
import com.api_vendinha.api.domain.service.ProdutoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gerenciar operações relacionadas aos produtos.
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoServiceInterface produtoService;

    @Autowired
    public ProdutoController(ProdutoServiceInterface produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoResponseDto salvar(@RequestBody ProdutoRequestDto produtoRequestDto) {
        return produtoService.save(produtoRequestDto);
    }

    @PutMapping("/{id}")
    public ProdutoResponseDto update(
            @PathVariable long id,
            @RequestBody ProdutoRequestDto produtoRequestDto
    ) {
        return produtoService.update(id, produtoRequestDto);
    }

    @GetMapping("/{id}")
    public ProdutoResponseDto produtoById(
            @PathVariable long id
    ) {
        return produtoService.getId(id);
    }

    @PutMapping("/{id}/status")
    public ProdutoResponseDto setActive(
            @PathVariable long id,
            @RequestBody ProdutoRequestDto produtoRequestDto
    ) {
        return produtoService.setActive(id, produtoRequestDto);
    }
}