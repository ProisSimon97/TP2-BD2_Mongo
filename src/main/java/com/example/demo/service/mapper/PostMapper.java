package com.example.demo.service.mapper;

import com.example.demo.model.Post;
import org.bson.Document;

import java.time.ZoneId;

public class PostMapper {
    public static Post map(Document document) {
        return Post.builder()
                .id(document.getObjectId("_id").toString())
                .title(document.getString("title"))
                .resume(document.getString("resume"))
                .text(document.getString("text"))
                .tags(document.getList("tags", String.class))
                .relatedLinks(document.getList("relatedLinks", String.class))
                .author(document.getString("author"))
                .date(document.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .build();
    }
}
