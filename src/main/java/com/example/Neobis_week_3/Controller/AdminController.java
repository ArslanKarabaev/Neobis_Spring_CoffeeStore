package com.example.Neobis_week_3.Controller;

import com.example.Neobis_week_3.Dto.UsersDto;
import com.example.Neobis_week_3.Entity.Coffee;
import com.example.Neobis_week_3.Entity.Users;
import com.example.Neobis_week_3.Service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping (path = "api/v1/CoffeeStore/admin/")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping(path = "getAllUsers")
    public ResponseEntity<List<UsersDto>> getAllUsers(){
        return ResponseEntity.ok( adminService.getAllUsersDto());
    }
    //    public List<UsersDto> getAllUsers(){
//         return userService.getAllUsersDto();


    @GetMapping(path = "getUserById/{user_id}")
    public UsersDto getUserById(@PathVariable("user_id") Long user_id){
        return adminService.getUserDtoById(user_id);

    }

    @PostMapping(path = "addNewUser")
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

    @PostMapping(path = "addNewCoffee")
    public void addNewCoffee(@RequestBody Coffee coffee) {
        adminService.addNewCoffee(coffee);
    }

    @DeleteMapping(path = "{coffee_id}")
    public void deleteCoffee(@PathVariable("coffee_id") Long coffee_id) {
        adminService.deleteCoffee(coffee_id);
    }
}
