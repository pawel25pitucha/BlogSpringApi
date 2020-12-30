package com.BlogApi.BlogApi.Models.Mappers;


import com.BlogApi.BlogApi.Models.Comment;
import com.BlogApi.BlogApi.Models.ModelsDto.CommentDto;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class CommentDtoToComment {

    public Comment convertCommentDtoToComment(CommentDto newComment){
        String id = UUID.randomUUID().toString();
        String postId = newComment.getPostId();
        String username = newComment.getUsername();
        String comment= newComment.getCommentContent();

        return new Comment(id,postId,username,comment);
    }
}
