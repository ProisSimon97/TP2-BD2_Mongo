package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Post {
    private String id;
    private String title;
    private String resume;
    private String text;
    private List<String> tags;
    private List<String> relatedLinks;
    private String author;
    private LocalDateTime date;
}