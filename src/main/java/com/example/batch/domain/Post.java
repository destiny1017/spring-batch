package com.example.batch.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private Long id;

    private String title;

    private String content;

}
