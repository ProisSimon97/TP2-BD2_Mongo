package com.example.demo.web.request;

import java.time.LocalDateTime;
import java.util.List;

public record PostCreateRequest(
         String title,
         String resume,
         String text,
         List<String>tags,
         List<String> relatedLinks,
         String author,
         LocalDateTime date
) {
}
