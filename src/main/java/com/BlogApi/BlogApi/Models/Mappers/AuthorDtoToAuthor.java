package com.BlogApi.BlogApi.Models.Mappers;

import com.BlogApi.BlogApi.Models.Author;
import com.BlogApi.BlogApi.Models.ModelsDto.AuthorDto;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;


@Configuration
public class AuthorDtoToAuthor {

    public Author convertAuthorDtoToAuthor(AuthorDto authorDto){
        String id = UUID.randomUUID().toString();
        String name = authorDto.getName();
        return new Author(id,name);
    }
}
