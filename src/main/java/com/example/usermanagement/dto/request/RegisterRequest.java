package com.example.usermanagement.dto.request;

import javax.validation.constraints.NotBlank;


public record RegisterRequest(

        @NotBlank String name,
        @NotBlank String surname,
        @NotBlank String email,
        @NotBlank String username,
        @NotBlank String password

) {
}
