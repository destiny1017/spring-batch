package com.example.batch.domain;

import java.util.List;

public interface PostRepository {
    Long save(Post post);
    List<Post> findAll();
}
