package com.example.demo.web;

import com.example.demo.model.Page;
import com.example.demo.service.page.PageService;
import com.example.demo.web.request.PageCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pages")
public class PageController {

    private final PageService service;

    @PostMapping
    public Page create(@RequestBody Page page) {
        return service.create(page);
    }

    @GetMapping("/{id}")
    public Page find(@PathVariable String id) {
        return service.find(id);
    }
}
