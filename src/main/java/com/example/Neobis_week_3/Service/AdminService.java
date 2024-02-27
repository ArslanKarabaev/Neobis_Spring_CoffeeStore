package com.example.Neobis_week_3.Service;

import com.example.Neobis_week_3.Dto.UsersDto;
import com.example.Neobis_week_3.Entity.Coffee;
import com.example.Neobis_week_3.Entity.Users;
import com.example.Neobis_week_3.Repository.CoffeeRepository;
import com.example.Neobis_week_3.Repository.UsersRepository;
import com.example.Neobis_week_3.Utils.UserMappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {
    public final UsersRepository usersRepository;
    private final CoffeeRepository coffeeRepository;
    private final UserMappingUtils userMappingUtils;

    @Autowired
    public AdminService(UsersRepository usersRepository, CoffeeRepository coffeeRepository, UserMappingUtils userMappingUtils) {
        this.usersRepository = usersRepository;
        this.coffeeRepository = coffeeRepository;
        this.userMappingUtils = userMappingUtils;
    }

    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    public List<UsersDto> getAllUsersDto() {
        return getAll().stream().map(userMappingUtils::mapToUsersDto).collect(Collectors.toList());
    }

    public Optional<Users> getUserById(Long user_id) {
        boolean exists = usersRepository.existsById(user_id);
        if (!exists) {
            throw new IllegalStateException("There is no Users with Id " + user_id);
        }
        return usersRepository.findById(user_id);
    }

    public UsersDto getUserDtoById(Long id) {
        return userMappingUtils.mapToUsersDto(getUserById(id).orElse(new Users()));
    }

    public void addNewUser(Users user) {
        Optional<Users> usersByFirstName = usersRepository.findUsersByFirstName(user.getFirstName());
        if (usersByFirstName.isPresent()) {
            throw new IllegalStateException("This user is already registered");
        }
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

    @Transactional
    public void deleteUser(Long userId) {
        Users user = usersRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "User with id " + userId + "  does not exists"));
        user.setStatus(false);
    }

    public void addNewCoffee(Coffee coffee) {
        Optional<Coffee> coffeeByName = coffeeRepository.findCoffeeByName(coffee.getName());
        if (coffeeByName.isPresent()) {
            throw new IllegalStateException("This coffee already added");
        }
        coffeeRepository.save(coffee);
    }

    public void deleteCoffee(Long coffee_id) {
        boolean exists = coffeeRepository.existsById(coffee_id);
        if (!exists) {
            throw new IllegalStateException("Coffee with id " + coffee_id + " does not exists");
        }
        coffeeRepository.deleteById(coffee_id);
    }


}
