package com.BlogApi.BlogApi.Services.AuthorsToPosts;

import com.BlogApi.BlogApi.Models.AuthorsToPosts;

import java.util.List;

public interface IAuthorsToPostsService {
    List getAllAuthorPosts(String id);
    List getAllPostAuthors(String id);
    AuthorsToPosts addPostAuthor(String authorId,String postId);
    boolean deleteAuthorFromPost(String authorId,String postId);
}
