package com.example.usermanagement.controller;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.request.RegisterRequest;
import com.example.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService service;

    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@Valid @RequestBody RegisterRequest request){
        final var dto = service.registerUser(request);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateById(@Valid @RequestBody RegisterRequest request,@PathVariable Long id){
        final var dto = service.updateUser(request,id);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").build(id);
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        final var dtoList = service.getAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
