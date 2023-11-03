package com.example.demo.web.request;

import java.time.LocalDateTime;

public record PageCreateRequest(
        String title,
        String text,
        String author,
        LocalDateTime date
) {
}
