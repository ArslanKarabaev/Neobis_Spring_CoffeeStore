package com.example.Neobis_week_3.Dto;

import com.example.Neobis_week_3.Enums.Role;

import java.time.LocalDate;

public record CreateUserDto (String firstName, String secondName, LocalDate dateOfBirth, String email, String mobNum, String password, Role role){
}
