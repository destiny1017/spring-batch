package com.example.batch.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PostEntityRepositoryTest {

    @Autowired
    PostRepository postRepository;

//    @BeforeEach
//    void clearData() {
//        postRepository.deleteAll();
//    }

    @Rollback(false)
    @Test
    void repositoryTest() {
        PostEntity post = PostEntity.builder()
                .title("title1")
                .content("content1")
                .build();

        postRepository.save(post);
        List<PostEntity> posts = postRepository.findAll();
        posts.forEach(p -> System.out.println(p.toString()));
        Optional<PostEntity> findPost = postRepository.findById(1L);
        System.out.println("post.toString() = " + findPost.toString());

    }

}