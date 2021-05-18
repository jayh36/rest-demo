package com.example.demo.repository;

import com.example.demo.model.Posts;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface PostsRepository {
        List<Posts> getAllPosts();
        Posts getPostsById(long id);
}
