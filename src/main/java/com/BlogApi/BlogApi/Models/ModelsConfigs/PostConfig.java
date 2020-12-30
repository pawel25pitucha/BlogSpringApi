package com.BlogApi.BlogApi.Models.ModelsConfigs;

import com.BlogApi.BlogApi.Models.Author;
import com.BlogApi.BlogApi.Models.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConfig {
    @Bean
    public Post post(){
        return new Post();
    }
}
