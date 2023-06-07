package com.example.springboottodoapp.loginRegistrationBackend.appuser.appuser;

import com.example.springboottodoapp.loginRegistrationBackend.appuser.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <AppUser, Long> {
    AppUser findByEmail(String email);
}
