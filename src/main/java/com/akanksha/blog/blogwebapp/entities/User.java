package com.akanksha.blog.blogwebapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="blog_User")
public class User {
    private String name;

    public User() {
    }

    public String getName() {
        return name;
    }

    public User(String name, String id) {
        this.name = name;
        this.user_id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return user_id;
    }

    public void setId(String id) {
        this.user_id = id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Id
    @Column(name="user_id")
    private String user_id;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
}
