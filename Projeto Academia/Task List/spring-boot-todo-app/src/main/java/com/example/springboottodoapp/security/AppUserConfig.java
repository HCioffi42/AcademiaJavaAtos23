package com.example.springboottodoapp.security;

import com.example.springboottodoapp.Models.AppUser;
import com.example.springboottodoapp.Repositories.AppUserReposiroty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppUserConfig {

    @Bean
    CommandLineRunner commandLineRunner(AppUserReposiroty appUserReposiroty){
        return args -> {
            AppUser appUser = new AppUser();

            appUser.setName("Henrique");
            appUser.setEmail("henrique.cioffi@mail.com");
            appUser.setRoles("ROLE_ADMIN");
            appUser.setPassword(passwordEncoder().encode("cioffi42"));
            appUserReposiroty.save(appUser);
            appUser = new AppUser();
            appUser.setName("Ana Cláudia");
            appUser.setEmail("ana.cioffi@mail.com");
            appUser.setRoles("ROLE_USER");
            appUser.setPassword(passwordEncoder().encode("cioffi42"));
            appUserReposiroty.save(appUser);
        };
    }

    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
