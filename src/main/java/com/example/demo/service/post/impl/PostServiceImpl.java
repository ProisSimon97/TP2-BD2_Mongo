package com.example.demo.service.post.impl;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    @Override
    public Post create(Post post) {
        return repository.save(post);
    }

    @Override
    public List<Post> findLatest() {
        return repository.findAll();
    }
}
