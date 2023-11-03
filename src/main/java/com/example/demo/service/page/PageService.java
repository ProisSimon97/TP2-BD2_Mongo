package com.example.demo.service.page;

import com.example.demo.model.Page;

public interface PageService {

    Page create(Page page);

    Page find(String id);
}
