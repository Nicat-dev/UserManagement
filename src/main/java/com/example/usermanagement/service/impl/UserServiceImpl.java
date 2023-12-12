package com.example.usermanagement.service.impl;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.request.RegisterRequest;
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
    public UserDto registerUser(RegisterRequest request) {
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }

    @Override
    public UserDto updateUser(RegisterRequest request, Long id) {
        idNullCheck(id);
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }

    @Override
    public void deleteById(Long id) {
        idNullCheck(id);
        repository.deleteById(id);
    }

    @Override
    public UserDto findById(Long id) {
        return entityToDto(id);
    }

    @Override
    public List<UserDto> getAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }


    //******Method Validations*****

    private UserDto entityToDto(Long id){
        return mapper.entityToDto(repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("User","id",id)));
    }

    private void idNullCheck(Long id){
        if (Objects.isNull(id)){
            throw new ResourceIdCanNotBeNull("null","Id cannot be null",id);
        }
    }

}
