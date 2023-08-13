package com.akanksha.blog.blogwebapp.payloads;

public class PostDto {

    private int post_id;
    private String title;
    private  String content;

    public PostDto() {
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PostDto(int post_id, String title, String content, UserDto user) {
        this.post_id = post_id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    private UserDto user;

}
