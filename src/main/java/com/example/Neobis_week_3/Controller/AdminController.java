package com.example.Neobis_week_3.Controller;

import com.example.Neobis_week_3.Dto.UsersDto;
import com.example.Neobis_week_3.Entity.Users;
import com.example.Neobis_week_3.Service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping (path = "api/v1/CoffeeStore/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping(path = "getAllUsers")
    public ResponseEntity<UsersDto> getAllUsers(){
        return ResponseEntity.ok((UsersDto) adminService.getAllUsersDto());
    }
    //    public List<UsersDto> getAllUsers(){
//         return userService.getAllUsersDto();


    @GetMapping(path = "getUserById/{user_id}")
    public UsersDto getUserById(@PathVariable("user_id") Long user_id){
        return adminService.getUserDtoById(user_id);

    }

    @PostMapping
    public void addNewUser(@RequestBody Users user){
        adminService.addNewUser(user);
    }

    @PutMapping(path = "updateUser/{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String secondName,
            @RequestParam(required = false) LocalDate dateOfBirth,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String mobnum,
            @RequestParam(required = false) String password){
        adminService.updateUser(userId,firstName,secondName,dateOfBirth,email,mobnum,password);
    }

    @PutMapping(path = "delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        adminService.deleteUser(userId);
    }
}
