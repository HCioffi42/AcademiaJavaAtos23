package com.example.springboottodoapp.loginRegistrationBackend.appuser.registration;

import com.example.springboottodoapp.loginRegistrationBackend.appuser.appuser.AppUser;
import com.example.springboottodoapp.loginRegistrationBackend.appuser.appuser.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupForm(){
        return "signup";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String passsword){
        AppUser appUser = userRepository.findByEmail(email);

        if(appUser == null){
            return "redirect:/login?error=User not found";
        }
        if(appUser.getPassword().equals(passsword)){
            return "redirect:/index";
        }else{
            return "redirect:/login?error=Invalid Password";
        }
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute("user")AppUser appUser){

        AppUser user = new AppUser();
        user.setFirstName(appUser.getFirstName());
        user.setLastName(appUser.getLastName());
        user.setEmail(appUser.getEmail());
        user.setPassword(appUser.getPassword());

        userRepository.save(appUser);
        return "redirect:/login";
    }


}
