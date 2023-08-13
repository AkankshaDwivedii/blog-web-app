package com.akanksha.blog.blogwebapp.entities;


import jakarta.persistence.*;

@Entity
@Table(name="blog_post")
public class Post {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    int post_id;

    public Post() {
    }

    String title;

    public Post(int post_id, String title, String content, User user) {
        this.post_id = post_id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    String content;

    @ManyToOne
            @JoinColumn(name="user_id")
    User user;


}
