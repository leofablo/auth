package com.montrackii.fixmontrack.user.dto;

import com.montrackii.fixmontrack.user.entity.Users;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class RegisterRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotNull
    @Min(1)
    private int activeCurrency;

    public Users toEntity() {
        Users user = new Users();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setCurrency(activeCurrency);
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());
        return user;
    }



}
