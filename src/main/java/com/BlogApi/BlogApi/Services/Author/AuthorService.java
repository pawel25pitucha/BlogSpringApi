package com.BlogApi.BlogApi.Services.Author;

import com.BlogApi.BlogApi.Models.AuthorStats;
import com.BlogApi.BlogApi.Repositories.Author.IAuthorRepository;
import com.BlogApi.BlogApi.Models.Author;
import com.BlogApi.BlogApi.Repositories.AuthorsToPosts.IAuthorsToPostsRepository;
import com.BlogApi.BlogApi.Repositories.Comment.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    private final IAuthorRepository repository;
    private final IAuthorsToPostsRepository authorsToPostsRepository;
    private final ICommentRepository commentRepository;

    @Autowired
    public AuthorService(IAuthorRepository authorRepository, IAuthorsToPostsRepository authorsToPostsRepository, ICommentRepository commentRepository) {
        this.repository=authorRepository;
        this.authorsToPostsRepository = authorsToPostsRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return repository.getAllAuthors();
    }

    @Override
    public Author getAuthor(String id) {
        return repository.getAuthor(id);
    }

    @Override
    public Author getAuthorByName(String name) {
        return repository.getAuthorByName(name);
    }

    @Override
    public Author addAuthor(Author newAuthor) {
        return repository.addAuthor(newAuthor);
    }

    @Override
    public boolean editAuthor(Author newAuthor) {
        return repository.editAuthor(newAuthor);
    }

    @Override
    public AuthorStats getAuthorsStats(String authorId) {
            int posts = authorsToPostsRepository.getAllAuthorPosts(authorId).size();
            Author author = repository.getAuthor(authorId);
            int comments = commentRepository.getAuthorComments(author.getName()).size();
        return new AuthorStats(posts, comments);
    }
}
