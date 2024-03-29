package com.example.Neobis_week_3.Dto;

import com.example.Neobis_week_3.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    
    private Long user_id;
    private String firstName;
    private String secondName;
    private LocalDate dateOfBirth;
    private String email;
    private String mobNum;
    private String password;
    private Boolean status = true;
    private Integer age;
    private Role role;

    public UsersDto(String firstName, String secondName, LocalDate dateOfBirth, String email, String mobNum, String password, Role role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobNum = mobNum;
        this.password = password;
        this.role = role;

    }
}
