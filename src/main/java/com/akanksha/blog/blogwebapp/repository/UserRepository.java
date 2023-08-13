package com.akanksha.blog.blogwebapp.repository;

import com.akanksha.blog.blogwebapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
