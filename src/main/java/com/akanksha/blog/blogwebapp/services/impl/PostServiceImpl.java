package com.akanksha.blog.blogwebapp.services.impl;

import com.akanksha.blog.blogwebapp.entities.Post;
import com.akanksha.blog.blogwebapp.entities.User;
import com.akanksha.blog.blogwebapp.payloads.PostDto;
import com.akanksha.blog.blogwebapp.repository.PostRepository;
import com.akanksha.blog.blogwebapp.repository.UserRepository;
import com.akanksha.blog.blogwebapp.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    UserRepository userRepository;
    PostRepository postRepository;
    ModelMapper modelMapper;
    public PostServiceImpl(UserRepository userRepository, ModelMapper modelMapper,PostRepository postRepository)
    {
        this.userRepository=userRepository;
        this.modelMapper=modelMapper;
        this.postRepository = postRepository;
    }
    @Override
    public PostDto CreatePost(PostDto postDto, String userID) {

        User user = userRepository.findById(userID).
                orElseThrow(()->new ResourceNotFoundException("user not found"));

        Post post = modelMapper.map(postDto, Post.class);
        post.setUser(user);
        postRepository.save(post);
        return modelMapper.map(post,PostDto.class);

    }

    @Override
    public List<PostDto> getAllPost() {
      List<Post> posts=  postRepository.findAll(); List<PostDto> postDtos=posts.stream().map(p->modelMapper.
                map(p,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }
 /*
    @Override
    public PostDto UpdatePost(PostDto postDto, int post_id) {
        return null;
    }

    @Override
    public void DeletePost(PostDto postDto) {

    }
    */


    @Override
    public List<PostDto> getPostbyUser(String UserId) {

       User user= userRepository.findById(UserId).
               orElseThrow(()->new ResourceNotFoundException("user not found"));

       List<Post> posts= user.getPosts();
       List<PostDto> postDtos=posts.stream().map(p->modelMapper.
               map(p,PostDto.class)).collect(Collectors.toList());
       return postDtos;

    }

}
