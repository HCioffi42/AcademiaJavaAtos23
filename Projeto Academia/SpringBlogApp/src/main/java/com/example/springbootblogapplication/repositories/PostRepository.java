package com.example.springbootblogapplication.repositories;

import com.example.springbootblogapplication.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<BlogPost, Long> {
}

