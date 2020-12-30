package com.BlogApi.BlogApi.Models;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public  class AuthorStats  {
    private int postsNumber;
    private int commentsNumber;

}
