package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.request.RegisterRequest;

import java.util.List;

public interface UserService {

    UserDto registerUser(RegisterRequest request);
    UserDto updateUser(RegisterRequest request,Long id);
    void deleteById(Long id);
    UserDto findById(Long id);
    List<UserDto> getAll();

}
