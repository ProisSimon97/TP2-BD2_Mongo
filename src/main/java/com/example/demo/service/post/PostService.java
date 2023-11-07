package com.example.demo.service.post;

import com.example.demo.model.Post;

import java.util.List;

public interface PostService {
    void create(Post post);

    List<Post> findLatest();
}
