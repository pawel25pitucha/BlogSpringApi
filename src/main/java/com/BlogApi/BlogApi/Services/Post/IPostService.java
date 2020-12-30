package com.BlogApi.BlogApi.Services.Post;

import com.BlogApi.BlogApi.Models.Post;

import java.util.List;

public interface IPostService {
    List<Post> getAllPosts();

    Post getPost(String id);

    List<Post> getPostByTag(String tag);

    Post addPost(Post newPost);

    boolean deletePost(String id);

    Post editPost( Post editPost);
    List getPostsByTag(String tag);

}
