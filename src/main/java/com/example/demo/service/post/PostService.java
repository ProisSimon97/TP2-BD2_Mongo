package com.example.demo.service.post;

import com.example.demo.model.Post;

import java.util.List;

public interface PostService {
    Post create(Post post);

    List<Post> findLatest();
}
