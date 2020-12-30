package com.BlogApi.BlogApi.Services.Author;

import com.BlogApi.BlogApi.Models.Author;
import com.BlogApi.BlogApi.Models.AuthorStats;

import java.util.List;

public interface IAuthorService {
    List<Author> getAllAuthors();
    Author getAuthor(String id);
    Author getAuthorByName(String name);
    Author addAuthor(Author newAuthor);
    boolean editAuthor(Author newAuthor);
    AuthorStats getAuthorsStats(String authorId);


}
