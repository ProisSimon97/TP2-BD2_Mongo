package com.example.demo.service.mapper;

import com.example.demo.model.Page;
import com.example.demo.model.Post;
import org.bson.Document;

import java.time.ZoneId;

public class PageMapper {
    public static Page map(Document document) {
        return Page.builder()
                .id(document.getObjectId("_id").toString())
                .title(document.getString("title"))
                .text(document.getString("text"))
                .author(document.getString("author"))
                .date(document.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .build();
    }
}
