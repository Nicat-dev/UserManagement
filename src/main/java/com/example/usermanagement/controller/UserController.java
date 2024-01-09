package com.example.usermanagement.controller;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.dto.request.RegisterRequest;
import com.example.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final  UserService service;

    @PostMapping
    public ResponseEntity<UserDto> save(@Valid @RequestBody RegisterRequest request) {
        final var dto = service.create(request);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateById(@Valid @RequestBody RegisterRequest request,
                                              @PathVariable Long id) {
        final var dto = service.update(request, id);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").build(id);
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        final var dtoList = service.getAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getOne(@PathVariable Long id){
        final var dto = service.getOne(id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
