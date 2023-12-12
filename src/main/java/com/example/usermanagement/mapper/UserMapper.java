package com.example.usermanagement.mapper;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.request.RegisterRequest;
import com.example.usermanagement.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapToDto(User users);

    List<UserDto> mapToDto(List<User> users);

    User requestToEntity(RegisterRequest request);
}
