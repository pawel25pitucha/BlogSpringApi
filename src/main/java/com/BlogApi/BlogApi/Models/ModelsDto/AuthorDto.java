package com.BlogApi.BlogApi.Models.ModelsDto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class AuthorDto {
    @NotEmpty
    private String name;
}
