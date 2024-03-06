package com.example.Neobis_week_3.Service.UsersService;

import com.example.Neobis_week_3.Entity.Users;
import com.example.Neobis_week_3.Repository.UsersRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsersService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    public UsersService(PasswordEncoder passwordEncoder, UsersRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = userRepository;
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
        usersRepository.save(user);
    }

    @Transactional
    public void updateUser(Long userId,
                           String firstName,
                           String secondName,
                           LocalDate dateOfBirth,
                           String email,
                           String mobnum) {
        Users users = usersRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "User with id " + userId + "  does not exists"));

        if (firstName != null && firstName.length() > 0 && !Objects.equals(users.getFirstName(), firstName)) {
            users.setFirstName(firstName);
        }

        if (email != null && email.length() > 0 && !Objects.equals(users.getEmail(), email)) {
            Optional<Users> usersOptional = usersRepository.findUsersByEmail(email);
            if (usersOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            users.setEmail(email);
        }

        if (secondName != null && secondName.length() > 0 && !Objects.equals(users.getSecondName(), secondName)) {
            users.setSecondName(secondName);
        }

        if (dateOfBirth != null && !Objects.equals(users.getDateOfBirth(), dateOfBirth)) {
            users.setDateOfBirth(dateOfBirth);
        }

        if (mobnum != null && mobnum.length() > 0 && !Objects.equals(users.getMobNum(), mobnum)) {
            users.setMobNum(mobnum);
        }

    }
}
