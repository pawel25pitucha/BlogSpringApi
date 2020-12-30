package com.BlogApi.BlogApi.Models;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorsToPosts {
    @NotEmpty
    @CsvBindByName
    private String postId;
    @NotEmpty
    @CsvBindByName
    private String authorId;
}
