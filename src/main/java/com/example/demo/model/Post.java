package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "post")
public class Post {

    @Id
    private String id;
    private String title;
    private String resume;
    private String text;
    private List<String> tags;
    private List<String> relatedLinks;
    private String author;
    private LocalDateTime date;
}