package com.example.Neobis_week_3.Dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UsersDto {
    @Id
    @SequenceGenerator(name = "Users_sequence",
            sequenceName = "Users_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Users_sequence")
    private Long user_id;
    private String firstName;
    private String secondName;
    private LocalDate dateOfBirth;
    private String email;
    private String mobNum;
    private String password;
    private Boolean status = true;
    private Integer age;

    public UsersDto(String firstName, String secondName, LocalDate dateOfBirth, String email, String mobNum, String password, Boolean status, Integer age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobNum = mobNum;
        this.password = password;
        this.status = status;
        this.age = age;
    }
}
