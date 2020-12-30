package com.BlogApi.BlogApi.Models.ModelsDto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class PostDto {
    private String tag;
    @NotEmpty
    private String postContent;
}
