package com.example.Neobis_week_3.Controller;

import com.example.Neobis_week_3.Service.UsersService.ChangePasswordRequest;
import com.example.Neobis_week_3.Service.UsersService.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping (path = "api/v1/CoffeeStore/User/ChangePassword")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
}
