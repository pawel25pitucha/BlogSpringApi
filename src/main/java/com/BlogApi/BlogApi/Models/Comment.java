package com.BlogApi.BlogApi.Models;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @NotNull
    @CsvBindByName
    private String id;
    @NotEmpty
    @CsvBindByName(column = "id_post")
    private String postId;
    @NotEmpty
    @CsvBindByName
    private String username;
    @NotEmpty
    @CsvBindByName(column="comment_content")
    private String commentContent;
}
