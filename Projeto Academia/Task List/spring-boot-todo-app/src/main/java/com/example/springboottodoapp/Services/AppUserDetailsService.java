package com.example.springboottodoapp.Services;

import com.example.springboottodoapp.Models.AppUser;
import com.example.springboottodoapp.Repositories.AppUserReposiroty;
import com.example.springboottodoapp.security.AppUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    AppUserReposiroty appUserReposiroty;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = appUserReposiroty.findByName(username);
        return appUser.map(AppUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("User not fount on Data Base"+username));
    }
}
