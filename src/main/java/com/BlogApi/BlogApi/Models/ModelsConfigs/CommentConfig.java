package com.BlogApi.BlogApi.Models.ModelsConfigs;

import com.BlogApi.BlogApi.Models.Comment;
import com.BlogApi.BlogApi.Models.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentConfig {
    @Bean
    public Comment comment(){
        return new Comment();
    }
}
