package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Posts {
    Long id;
    String title;
    String content;
    String author;
}
