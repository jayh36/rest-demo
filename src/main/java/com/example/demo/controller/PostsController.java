package com.example.demo.controller;

import com.example.demo.model.Posts;
import com.example.demo.exception.DataNotFoundException;
import com.example.demo.service.PostsService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/posts")
public class PostsController {
    @Autowired
    PostsService postsService;

    // get all
    @GetMapping
    public ResponseEntity<?> getAllPosts(){
        List<Posts> posts = postsService.getAllPosts();
        if( posts == null ){
            throw new DataNotFoundException("Data not found");
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // get posts by id
    @GetMapping("/{id}")
    public ResponseEntity getPostsById(@PathVariable Long id) {
        Posts posts = postsService.getPostsById(id) ;
        if( posts == null ){
            throw new DataNotFoundException("Data not found");
        }
        return new ResponseEntity(posts, HttpStatus.OK);
    }

/*    @PostMapping
    public Posts createPosts(@RequestBody Posts posts) {
        return postsService.createPosts(posts);
    }*/

}
