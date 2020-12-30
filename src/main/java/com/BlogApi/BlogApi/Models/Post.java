package com.BlogApi.BlogApi.Models;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @NotNull
    @CsvBindByName
    private String id;
    @CsvBindByName
    private String tag;
    @NotEmpty
    @CsvBindByName(column = "post_content")
    private String postContent;



}
