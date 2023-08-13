package com.akanksha.blog.blogwebapp.services.impl;

import com.akanksha.blog.blogwebapp.entities.User;
import com.akanksha.blog.blogwebapp.exceptions.UserNotFoundException;
import com.akanksha.blog.blogwebapp.payloads.UserDto;
import com.akanksha.blog.blogwebapp.repository.UserRepository;
import com.akanksha.blog.blogwebapp.services.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{


    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = DtotoUser(userDto);
        userRepository.save(user);
        return UsertoDto(user);
    }

    @Override
    public UserDto UpdateUser(UserDto userDto, String UserId) {
        User user = userRepository.findById(UserId).
                orElseThrow(()->new UserNotFoundException("userid"+UserId+" not found"));
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        userRepository.save(user);
        return UsertoDto(user);
    }

    @Override
    public UserDto getUserbyId(String UserId) {
        User user = userRepository.findById(UserId).
                orElseThrow(()->new UserNotFoundException("userid"+UserId+" not found"));
        return UsertoDto(user);
    }

    @Override
    public List<UserDto> getallUser() {
        List<User> users = userRepository.findAll();

      List<UserDto> usersList=
              users.stream().map(user->UsertoDto(user)).
                      collect(Collectors.toList());
      return usersList;
    }

    @Override
    public void deleteUser(String UserId) {
        User user = userRepository.findById(UserId).
                orElseThrow(()->new UserNotFoundException("userid"+UserId+" not found"));
        userRepository.delete(user);
    }


    private UserDto UsertoDto(User user)
    {
               UserDto userDto = new UserDto(user.getName(), user.getId());
               return userDto;
    }

    private User DtotoUser(UserDto userDto)
    {
        User user = new User(userDto.getName(), userDto.getId());
        return user;
    }
}
