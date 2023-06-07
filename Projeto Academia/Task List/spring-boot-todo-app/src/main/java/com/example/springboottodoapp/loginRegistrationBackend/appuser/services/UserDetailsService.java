package com.example.springboottodoapp.loginRegistrationBackend.appuser.services;

import com.example.springboottodoapp.loginRegistrationBackend.appuser.appuser.AppUser;
import com.example.springboottodoapp.loginRegistrationBackend.appuser.appuser.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements ServiceRepository {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByEmail(String email) throws Exception {
        AppUser appUser = userRepository.findByEmail(email);
        if(appUser == null){
            throw new Exception("User not Found");
        }
        return new org.springframework.security.core.userdetails.User(appUser.getEmail(), appUser.getPassword(),);
    }

}
