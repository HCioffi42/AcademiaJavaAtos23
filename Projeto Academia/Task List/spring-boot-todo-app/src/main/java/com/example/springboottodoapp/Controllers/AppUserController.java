package com.example.springboottodoapp.Controllers;

import com.example.springboottodoapp.Models.AppUser;
import com.example.springboottodoapp.Repositories.AppUserReposiroty;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class AppUserController {
    private PasswordEncoder passwordEncoder;
    private AppUserReposiroty appUserReposiroty;

    @PostMapping("/adduser")
    public String addNewUser(@RequestBody AppUser appUser){
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserReposiroty.save(appUser);
        return "User Added on Data base.";
    }
}
