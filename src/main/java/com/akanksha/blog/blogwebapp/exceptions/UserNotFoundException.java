package com.akanksha.blog.blogwebapp.exceptions;

public class UserNotFoundException extends RuntimeException {

   private String message;
   public UserNotFoundException(String message)
   {
       this.message=message;
   }

}
