package com.akanksha.blog.blogwebapp.payloads;

public class UserDto {
    private String name;
    private String id;

    public UserDto(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public UserDto() {
    }

    public void setId(String id) {
        this.id = id;
    }
}
