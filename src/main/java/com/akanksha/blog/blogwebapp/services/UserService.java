package com.akanksha.blog.blogwebapp.services;

import com.akanksha.blog.blogwebapp.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto UpdateUser(UserDto userDto,String UserId);

    UserDto getUserbyId(String UserId);

    List<UserDto> getallUser();

    void deleteUser(String UserId);


}
