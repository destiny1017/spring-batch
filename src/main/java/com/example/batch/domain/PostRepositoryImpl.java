package com.example.batch.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Long save(Post post) {
        String sql = "insert into service.post(title, content) values(?, ?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    public List<Post> findAll() {
        String sql = "select * from service.post";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            return Post.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .content(rs.getString("content"))
                    .build();
        });
    }


}
