package com.akanksha.blog.blogwebapp.controllers;


import com.akanksha.blog.blogwebapp.entities.User;
import com.akanksha.blog.blogwebapp.payloads.UserDto;
import com.akanksha.blog.blogwebapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/users")
public class UserController {


    private UserService userService;
    public  UserController(UserService userService)
    {
        this.userService= userService;
    }

    @PostMapping("/")
    private ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
        UserDto userdto = userService.createUser(userDto);
        return new ResponseEntity<>(userdto, HttpStatus.CREATED);
    }

    @PutMapping("/{UserId}")
    private ResponseEntity<String> UpdateUser(@RequestBody UserDto userDto,@PathVariable String UserId)
    {
        UserDto userDto1 = userService.UpdateUser(userDto,UserId);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @DeleteMapping("/{UserId}")
    private ResponseEntity<UserDto> DeleteUser(@PathVariable String UserId)
    {
        userService.deleteUser(UserId);
        return (ResponseEntity<UserDto>) ResponseEntity.status(HttpStatus.OK);
    }

    @GetMapping("/")
    private ResponseEntity<List<UserDto>> getUsers()
    {
        List<UserDto> users = userService.getallUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    private ResponseEntity<UserDto> getUserbyID(@PathVariable String userId)
    {
        UserDto userDto = userService.getUserbyId(userId);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }




}

