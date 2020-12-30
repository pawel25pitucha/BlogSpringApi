package com.BlogApi.BlogApi.Repositories.Author;

import com.BlogApi.BlogApi.Models.Author;

import java.util.List;

public interface IAuthorRepository {
    List<Author> getAllAuthors();
    Author getAuthor(String id);
    Author getAuthorByName(String name);
    Author addAuthor(Author newAuthor);
    boolean editAuthor(Author newAuthor);
    boolean deleteAuthor(String id);
}
