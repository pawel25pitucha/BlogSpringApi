package com.BlogApi.BlogApi.Repositories.AuthorsToPosts;

import com.BlogApi.BlogApi.Models.AuthorsToPosts;

import java.util.List;
import java.util.Optional;

public interface IAuthorsToPostsRepository {
    List<AuthorsToPosts> getAllAuthorPosts(String id);
    List<AuthorsToPosts> getAllPostAuthors(String id);
    boolean deletePost(String id);
    boolean deleteAuthorFromPost(String authorId,String postId);
    AuthorsToPosts addPost(String postId, String authorId);


}
