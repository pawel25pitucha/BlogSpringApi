package com.BlogApi.BlogApi.Repositories.Post;

import com.BlogApi.BlogApi.Models.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> getAllPosts();

    Post getPost(String id);

    List<Post> getPostByTag(String tag);
    Post addPost(Post newPost);
    boolean deletePost(String id);
    Post editPost(Post editPost);
    List getPostsByTag(String tag);
}
