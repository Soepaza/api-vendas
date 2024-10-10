package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.Infrastructure.Repository.ProdutoRepository;
import com.api_vendinha.api.Infrastructure.repository.UserRepository;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.entities.Produto;
import com.api_vendinha.api.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceInterface {

    // Repositório para a persistência de dados de usuários.
    private final UserRepository userRepository;


    private final ProdutoRepository produtoRepository;

    /**
     * Construtor para injeção de dependência do UserRepository.
     *
     * @param userRepository O repositório de usuários a ser injetado.
     */
    public UserServiceImpl(com.api_vendinha.api.Infrastructure.repository.UserRepository userRepository, ProdutoRepository produtoRepository) {
        this.userRepository = userRepository;
        this.produtoRepository = produtoRepository;
    }

    /**
     * Salva um novo usuário ou atualiza um usuário existente.
     * <p>
     * Cria uma nova entidade User a partir dos dados fornecidos no UserRequestDto, persiste essa
     * entidade no banco de dados, e retorna um UserResponseDto com as informações do usuário salvo.
     *
     * @param userRequestDto DTO contendo os dados do usuário a ser salvo ou atualizado.
     * @return DTO com as informações do usuário salvo, incluindo o ID gerado e o nome.
     */
    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        // Cria uma nova instância de User.
        User user = new User();
        // Define o nome do usuário a partir do DTO.
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setCep(userRequestDto.getCep());
        user.setCpf(userRequestDto.getCpf());
        user.setIs_active(Boolean.TRUE);


        // Salva o usuário no banco de dados e obtém a entidade persistida com o ID gerado.
        User savedUser = userRepository.save(user);


        List<Produto> produtos = userRequestDto.getProdutoRequestDto().stream().map(dto -> {
            Produto produto = new Produto();
            produto.setUser(savedUser);
            produto.setQuantidade(dto.getQuantidade());
            produto.setName(dto.getName());
            produto.setPreco(dto.getPreco());
            produto.setIsActive(dto.getIsActive());
            return produto;
        }).collect(Collectors.toList());

        produtoRepository.saveAll(produtos);

        // Retorna o DTO com as informações do usuário salvo.
        return this.getUserResponseDto(user);
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow();

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setCep(userRequestDto.getCep());
        user.setCpf(userRequestDto.getCpf());
        user.setIs_active(Boolean.TRUE);

        userRepository.save(user);

        return getUserResponseDto(user);
    }


    @Override
    public UserResponseDto getId(Long id) {
        User user = userRepository.findById(id).orElseThrow();

        return getUserResponseDto(user);
    }

    @Override
    public UserResponseDto setActive(long id, UserRequestDto is_active) {
        User user = userRepository.findById(id).orElseThrow();

        user.setIs_active(is_active.getIs_active());
        userRepository.save(user);

        return getUserResponseDto(user);
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