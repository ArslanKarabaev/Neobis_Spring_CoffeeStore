package com.example.Neobis_week_3.Controller;

import com.example.Neobis_week_3.Dto.CoffeeDto;
import com.example.Neobis_week_3.Service.CoffeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/CoffeeStore/Coffee/")
public class CoffeeController {
    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @Operation(
            description = "Get All Coffee endpoint for ADMIN,MANAGER,USER",
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
    @GetMapping(path = "getAllCoffee")
    public ResponseEntity<List<CoffeeDto>> getAllCoffee() {
        return ResponseEntity.ok(coffeeService.getAllCoffeeDto());
    }

    @Operation(
            description = "Get Coffee By ID endpoint for ADMIN,MANAGER,USER",
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
    @GetMapping(path = "getCoffeeById/{coffee_id}")
    public ResponseEntity<Optional<CoffeeDto>> getCoffeeById(@PathVariable("coffee_id") Long coffee_id){
        return ResponseEntity.ok(coffeeService.getCoffeeByIdDto(coffee_id));
    }

}
