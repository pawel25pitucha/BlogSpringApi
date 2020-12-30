package com.BlogApi.BlogApi.Models.Mappers;
import com.BlogApi.BlogApi.Models.ModelsDto.PostDto;
import com.BlogApi.BlogApi.Models.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class PostDtoToPost {
 
    public Post convertPostDtoToPost(PostDto newpost){
        String id = UUID.randomUUID().toString();
        String content= newpost.getPostContent();
        String tag = newpost.getTag();
        Post post = new Post(id,tag,content);

        return post;
    }
}
