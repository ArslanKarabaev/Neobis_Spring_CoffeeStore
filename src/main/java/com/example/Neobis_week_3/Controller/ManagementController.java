package com.example.Neobis_week_3.Controller;

import com.example.Neobis_week_3.Dto.UsersDto;
import com.example.Neobis_week_3.Entity.Users;
import com.example.Neobis_week_3.Service.ManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/CoffeeStore/management")
public class ManagementController {
    private final ManagementService managementService;

    public ManagementController(ManagementService adminService) {
        this.managementService = adminService;
    }


    @GetMapping(path = "getAllUsers")
    public ResponseEntity<List<UsersDto>> getAllUsers() {
        return ResponseEntity.ok(managementService.getAllUsersDto());
    }
    //    public List<UsersDto> getAllUsers(){
//         return userService.getAllUsersDto();


    @GetMapping(path = "getUserById/{user_id}")
    public UsersDto getUserById(@PathVariable("user_id") Long user_id) {
        return managementService.getUserDtoById(user_id);

    }

    @PostMapping
    public void addNewUser(@RequestBody Users user) {
        managementService.addNewUser(user);
    }

}
