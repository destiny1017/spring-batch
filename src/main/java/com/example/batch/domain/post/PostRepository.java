package com.example.batch.domain.post;

import java.util.List;

public interface PostRepository {
    Long save(Post post);
    List<Post> findAll();
}
