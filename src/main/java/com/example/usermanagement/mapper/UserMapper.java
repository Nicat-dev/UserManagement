package com.example.usermanagement.mapper;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.request.RegisterRequest;
import com.example.usermanagement.model.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDto entityToDto(Users users);
    Users requestToEntity(RegisterRequest request);
    UserDto requestToDto(RegisterRequest request);
    List<UserDto> entityListToDtoList(List<Users> users);
}
