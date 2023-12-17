package com.example.usermanagement.service.impl;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.request.RegisterRequest;
import com.example.usermanagement.exception.ResourceExistsException;
import com.example.usermanagement.exception.ResourceIdCanNotBeNull;
import com.example.usermanagement.exception.ResourceNotFoundException;
import com.example.usermanagement.mapper.UserMapper;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDto create(RegisterRequest request) {
        emailAndUsernameValidation(request.email());
        return mapper.mapToDto(repository.save(mapper.requestToEntity(request)));
    }

    @Override
    public UserDto update(RegisterRequest request, Long id) {
        // todo: check username, email unique
        emailAndUsernameValidation(request.email());
        return mapper.mapToDto(repository.save(mapper.requestToEntity(request)));
    }

    @Override
    public void delete(Long id) {
        idNullCheck(id);
        repository.deleteById(id);
    }

    @Override
    public UserDto getOne(Long id) {
        return findBy(id);
    }

    @Override
    public List<UserDto> getAll() {
        return mapper.mapToDto(repository.findAll());
    }


    //******Method Validations*****

    private UserDto findBy(Long id){
        return mapper.mapToDto(repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("User","id",id)));
    }

    private void idNullCheck(Long id){
        if (Objects.isNull(id)){
            throw new ResourceIdCanNotBeNull("null","Id cannot be null",id);
        }
    }

    private void emailAndUsernameValidation(String email){
        if (repository.existsByEmail(email)){
            throw new ResourceExistsException("Email is exist",email,email);
        }
    }

}
