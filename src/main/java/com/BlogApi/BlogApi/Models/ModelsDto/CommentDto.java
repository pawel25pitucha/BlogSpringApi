package com.BlogApi.BlogApi.Models.ModelsDto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CommentDto {

    @NotEmpty
    private String postId;
    @NotEmpty
    private String username;
    @NotEmpty
    private String commentContent;
}
