package com.example.demo.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Page {
    private String id;
    private String title;
    private String text;
    private String author;
    private LocalDateTime date;
}
