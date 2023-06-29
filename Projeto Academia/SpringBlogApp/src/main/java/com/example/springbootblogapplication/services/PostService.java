package com.example.springbootblogapplication.services;

import com.example.springbootblogapplication.models.BlogPost;
import com.example.springbootblogapplication.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Optional<BlogPost> getById(Long id) {
        return postRepository.findById(id);
    }

    public List<BlogPost> getAll() {
        return postRepository.findAll();
    }

    public BlogPost save(BlogPost blogPost) {
        if (blogPost.getId() == null) {
            blogPost.setCreatedAt(LocalDateTime.now());
        }
        blogPost.setUpdatedAt(LocalDateTime.now());
        return postRepository.save(blogPost);
    }

    public void delete(BlogPost blogPost) {
        postRepository.delete(blogPost);
    }

}
