package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.Infrastructure.Repository.ProdutoRepository;
import com.api_vendinha.api.Infrastructure.Repository.UserRepository;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.entities.Produto;
import com.api_vendinha.api.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {

    // Repositório para a persistência de dados de usuários.
    private final UserRepository userRepository;
    private final ProdutoRepository produtoRepository;

    public UserServiceImpl(UserRepository userRepository, ProdutoRepository produtoRepository) {
        this.userRepository = userRepository;
        this.produtoRepository = produtoRepository;
    }


    public UserResponseDto save(UserRequestDto userRequestDto) {

        List<Produto> produtos = userRequestDto.getProdutoRequestDto().stream().map(dto -> {
            Produto produto = new Produto();
            produto.setUser(savedUser);
            produto.setQuantidade(dto.getQuantidade());
            produto.setName(dto.getName());
            produto.setPreco(dto.getPreco());
            produto.setIsActive(dto.getIsActive());
            return produto;
        }).collect(Collectors.toList());

        // Cria uma nova instância de User.
        User user = new User();
        // Define o nome do usuário a partir do DTO.
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setCep(userRequestDto.getCep());
        user.setCpf(userRequestDto.getCpf());
        user.setIs_active(Boolean.TRUE); //mocando os dados


        User savedUser = userRepository.save(user);


        produtoRepository.saveAll(produtos);

        return this.getUserResponseDto(user);
    }

    public UserResponseDto updateCpf(String cpf, UserRequestDto userRequestDto){
        User user = userRepository.findByCpf(cpf).orElseThrow();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setCep(userRequestDto.getCep());
        user.setCpf(userRequestDto.getCpf());
        user.setIs_active(Boolean.TRUE);

        userRepository.save(user);

        return getUserResponseDto(user);
    }

    public UserResponseDto update(Long Id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(Id).orElseThrow();

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setCep(userRequestDto.getCep());
        user.setCpf(userRequestDto.getCpf());
        user.setIs_active(Boolean.TRUE);

        userRepository.save(user);

        return getUserResponseDto(user);
    }

    public Optional<User> findByCpf(String cpf) {

        return userRepository.findByCpf(cpf);
    }


    public Optional<User> findById(Long id) {

        return userRepository.findById(id);
    }

    private UserResponseDto getUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setCep(user.getCep());
        userResponseDto.setCpf(user.getCpf());
        userResponseDto.setIs_active(user.getIs_active());

        return userResponseDto;
    }
}