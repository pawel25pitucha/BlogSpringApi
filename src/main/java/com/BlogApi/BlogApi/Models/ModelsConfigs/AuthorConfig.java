package com.BlogApi.BlogApi.Models.ModelsConfigs;

import com.BlogApi.BlogApi.Models.Author;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AuthorConfig {
    @Bean
    public Author author(){
        return new Author();
    }

}
