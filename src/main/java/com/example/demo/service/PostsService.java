package com.example.demo.service;

import com.example.demo.repository.PostsRepository;
import com.example.demo.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {
    @Autowired
    PostsRepository postsRepository;

    public List<Posts> getAllPosts(){
        List<Posts> postsList = postsRepository.getAllPosts();
        return postsList;
    }

    public Posts getPostsById(long id){
        return postsRepository.getPostsById(id);
    }
}
