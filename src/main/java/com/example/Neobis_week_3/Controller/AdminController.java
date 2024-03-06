package com.example.Neobis_week_3.Controller;

import com.example.Neobis_week_3.Dto.UsersDto;
import com.example.Neobis_week_3.Entity.Coffee;
import com.example.Neobis_week_3.Service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/CoffeeStore/admin/")
@Tag(name = "Admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Operation(
            description = "Get All Users endpoint for ADMIN",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @GetMapping(path = "getAllUsers")
    public ResponseEntity<List<UsersDto>> getAllUsers(){
        return ResponseEntity.ok( adminService.getAllUsersDto());
    }


    @Operation(
            description = "Get User By ID endpoint for ADMIN",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @GetMapping(path = "getUserById/{user_id}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable("user_id") Long user_id){
        return ResponseEntity.ok(adminService.getUserDtoById(user_id));

    }

    @Operation(
            description = "Delete User By ID endpoint for ADMIN",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @PutMapping(path = "delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        adminService.deleteUser(userId);
    }

    @Operation(
            description = "Add New Coffee endpoint for ADMIN",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping(path = "addNewCoffee")
    public void addNewCoffee(@RequestBody Coffee coffee) {
        adminService.addNewCoffee(coffee);
    }

    @Operation(
            description = "Delete Coffee endpoint for ADMIN",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @DeleteMapping(path = "{coffee_id}")
    public void deleteCoffee(@PathVariable("coffee_id") Long coffee_id) {
        adminService.deleteCoffee(coffee_id);
    }
}
