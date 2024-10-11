package com.api_vendinha.api.controller;

import com.api_vendinha.api.Infrastructure.Repository.UserRepository;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.entities.User;
import com.api_vendinha.api.domain.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api") // Define o caminho base para as requisições deste controlador.
public class UserController {

    // Injeção de dependência do serviço de usuários.
    private final UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping ("/salvar")
    public UserResponseDto salvar(@RequestBody UserRequestDto userRequestDto) {
        // Chama o serviço para salvar o usuário e retorna a resposta.
        return userService.save(userRequestDto);
    }

    @PutMapping("/{id}")
    public UserResponseDto update(
            @PathVariable long id,
            @RequestBody UserRequestDto userRequestDto
    ){
        return userService.update(id, userRequestDto);
    }

    @GetMapping("/{id}")
    public Optional<User> userById(
            @PathVariable long id
    ){
        return userService.findById(id);
    }

    @GetMapping("/{cpf}")
    public Optional<User> userByCpf(
            @PathVariable String cpf
    ){
        return userService.findById(cpf);
    }
