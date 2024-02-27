package com.example.Neobis_week_3.Service.UsersService;

import com.example.Neobis_week_3.Entity.Users;
import com.example.Neobis_week_3.Repository.UsersRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.Principal;

@Service
public class UsersService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository repository;

    public UsersService(PasswordEncoder passwordEncoder, UsersRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (Users) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }

        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        repository.save(user);
    }
}
