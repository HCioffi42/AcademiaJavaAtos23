package com.example.springbootblogapplication.controllers;

import com.example.springbootblogapplication.models.BlogPost;
import com.example.springbootblogapplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home(Model model) {
        List<BlogPost> blogPosts = postService.getAll();
        model.addAttribute("posts", blogPosts);
        return "home";
    }

}
