package com.example.Neobis_week_3.Repository;

import com.example.Neobis_week_3.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u FROM Users u WHERE u.firstName = ?1")
    Optional<Users> findUsersByFirstName(String firstname);

    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    Optional<Users> findUsersByEmail(String email);


}
