package com.example.demo.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Page {
    private String id;
    private String title;
    private String text;
    private String author;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
