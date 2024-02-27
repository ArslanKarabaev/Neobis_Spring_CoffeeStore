package com.example.Neobis_week_3.Service;

import com.example.Neobis_week_3.Dto.UsersDto;
import com.example.Neobis_week_3.Entity.Users;
import com.example.Neobis_week_3.Repository.UsersRepository;
import com.example.Neobis_week_3.Utils.UserMappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagementService {
    public final UsersRepository usersRepository;
    private final UserMappingUtils userMappingUtils;

    @Autowired
    public ManagementService(UsersRepository usersRepository, UserMappingUtils userMappingUtils) {
        this.usersRepository = usersRepository;
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


}
