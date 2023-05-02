package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
 
}
