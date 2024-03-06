package com.project.site.Modules.User.service;

import java.util.List;
import java.util.stream.Collectors;

import com.project.site.Modules.User.model.entity.Users;
import com.project.site.Modules.User.repository.UserRepository;
import com.project.site.Modules.User.model.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> mapToDTO(user, new UserDTO()))
                .collect(Collectors.toList());
    }

    public UserDTO get(final Long id) {
        return userRepository.findById(id)
                .map(user -> mapToDTO(user, new UserDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final UserDTO userDTO) {
        final Users user = new Users();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final UserDTO userDTO) {
        final Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(final Users user, final UserDTO userDTO) {
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }

    private Users mapToEntity(final UserDTO userDTO, final Users user) {
        user.setName(userDTO.getName());
        return user;
    }

    //Static Methods
    public static Users MapDTOToEntity(UserDTO userDto) {
        Users user = Users.builder()
                .id(userDto.getId())
                .name(userDto.getName()).build();
        return user;
    }
}
