package com.example.springboottodoapp.Repositories;

import com.example.springboottodoapp.Models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserReposiroty extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByName (String username);
}
