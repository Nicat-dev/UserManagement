package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.request.RegisterRequest;

import java.util.List;

public interface UserService {

    UserDto create(RegisterRequest request);
    UserDto update(RegisterRequest request, Long id);
    void delete(Long id);
    UserDto getOne(Long id);
    List<UserDto> getAll();

}
