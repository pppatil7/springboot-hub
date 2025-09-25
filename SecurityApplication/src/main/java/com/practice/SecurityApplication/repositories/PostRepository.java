package com.practice.SecurityApplication.repositories;

import com.practice.SecurityApplication.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
