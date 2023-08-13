package com.akanksha.blog.blogwebapp.repository;

import com.akanksha.blog.blogwebapp.entities.Post;
import com.akanksha.blog.blogwebapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);

}
