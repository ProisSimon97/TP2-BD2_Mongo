package com.example.demo.service.page.impl;

import com.example.demo.model.Page;
import com.example.demo.repository.PageRepository;
import com.example.demo.service.page.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PageServiceImpl implements PageService {

    private final PageRepository repository;

    @Override
    public Page create(Page page) {
        return repository.save(page);
    }

    @Override
    public Page find(String id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
