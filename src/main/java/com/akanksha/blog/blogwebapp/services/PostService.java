package com.akanksha.blog.blogwebapp.services;

import com.akanksha.blog.blogwebapp.payloads.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;



public interface PostService {

    PostDto CreatePost(PostDto postDto,String userID);

  //  PostDto CreatePost(PostDto postDto, String userID);

   List<PostDto> getAllPost();
/*
    PostDto UpdatePost(PostDto postDto,int post_id);

    void DeletePost(PostDto postDto); */

    List<PostDto> getPostbyUser(String UserId);
}
