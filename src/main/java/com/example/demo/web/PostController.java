package com.example.demo.web;

import com.example.demo.model.Post;
import com.example.demo.service.post.PostService;
import com.example.demo.web.request.PostCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService service;

    @PostMapping
    public void create(Post post) {
        service.create(post);
    }

    @GetMapping
    public List<Post> latest() {
        return service.findLatest();
    }

}
