package com.example.extra_hours_amadeus.repository;


import com.example.extra_hours_amadeus.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
}