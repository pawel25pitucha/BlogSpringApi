package com.BlogApi.BlogApi.Services.AuthorsToPosts;

import com.BlogApi.BlogApi.Models.Author;
import com.BlogApi.BlogApi.Models.Post;
import com.BlogApi.BlogApi.Repositories.AuthorsToPosts.IAuthorsToPostsRepository;
import com.BlogApi.BlogApi.Models.AuthorsToPosts;
import com.BlogApi.BlogApi.Repositories.Author.AuthorRepository;
import com.BlogApi.BlogApi.Repositories.Post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorsToPostsService implements IAuthorsToPostsService {
    private final IAuthorsToPostsRepository repository;
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorsToPostsService(IAuthorsToPostsRepository authorsToPostsRepository, PostRepository postRepository , AuthorRepository authorRepository) {
        this.repository=authorsToPostsRepository;
        this.postRepository=postRepository;
        this.authorRepository=authorRepository;
    }

    @Override
    public List<Post> getAllAuthorPosts(String id) {
         return repository.getAllAuthorPosts(id).stream().map(AuthorsToPosts::getPostId).map(postRepository::getPost).collect(Collectors.toList());
    }

    @Override
    public List<Author> getAllPostAuthors(String id) {
        return repository.getAllPostAuthors(id).stream().map(AuthorsToPosts::getAuthorId).map(authorRepository::getAuthor).collect(Collectors.toList());
    }

    @Override
    public AuthorsToPosts addPostAuthor(String postId,String authorId ) {
        return repository.addPost(postId,authorId);
    }

    @Override
    public boolean deleteAuthorFromPost(String authorId, String postId) {
        return  repository.deleteAuthorFromPost(authorId,postId);
    }

}
