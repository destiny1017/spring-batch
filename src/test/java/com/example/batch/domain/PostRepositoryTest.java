package com.example.batch.domain;

import com.example.batch.domain.post.Post;
import com.example.batch.domain.post.PostRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepositoryImpl postRepository;

//    @BeforeEach
//    void clearData() {
//        postRepository.deleteAll();
//    }

    @Rollback(false)
    @Test
    void repositoryTest() {
        Post post = Post.builder()
                .title("test1")
                .content("test1")
                .build();
        Long postId = postRepository.save(post);
        System.out.println("postId = " + postId);
    }

    @Test
    void findAll() {
        List<Post> posts = postRepository.findAll();
        for (Post post : posts) {
            System.out.println("post = " + post.toString());
        }
    }

}