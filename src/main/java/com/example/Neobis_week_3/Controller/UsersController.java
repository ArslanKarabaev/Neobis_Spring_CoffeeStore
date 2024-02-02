package com.example.Neobis_week_3.Controller;

import com.example.Neobis_week_3.Models.Users;
import com.example.Neobis_week_3.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping (path = "api/v1/CoffeeStore/Users")
public class UsersController {
    private final UsersService userService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.userService = usersService;
    }

    @GetMapping("/registration")
    public String home(){
        return "Registration";
    }

    @GetMapping
    public List<Users> getAllUsers(){
         return userService.getAllUsers();
    }

    @GetMapping(path = "{user_id}")
    public Optional<Users> getUserById(@PathVariable("user_id") Long user_id){
        return userService.getUserById(user_id);
    }

    @PostMapping
    public void addNewUser(@RequestBody Users user){
        userService.addNewUser(user);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String secondName,
            @RequestParam(required = false) LocalDate dateOfBirth,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String mobnum,
            @RequestParam(required = false) String password){
        userService.updateUser(userId,firstName,secondName,dateOfBirth,email,mobnum,password);
    }

    @PutMapping(path = "delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
}
