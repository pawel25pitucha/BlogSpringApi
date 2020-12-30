package com.BlogApi.BlogApi.Repositories.Post;

import com.BlogApi.BlogApi.Models.CsvToBeansConverters.PostsCsvToBeansConventer;
import com.BlogApi.BlogApi.Models.Post;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private final List<Post> listofPosts;


    public PostRepository() throws IOException {
        this.listofPosts = new PostsCsvToBeansConventer().getPostsBeans();
    }

    @Override
    public List<Post> getAllPosts() {
        return listofPosts;
    }

    @Override
    public Post getPost(String id) {
        return listofPosts.stream().filter(post -> post.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Post> getPostByTag(String tag) {
        return listofPosts.stream().filter(post -> post.getTag().contains(tag)).collect(Collectors.toList());
    }

    @Override
    public Post addPost(Post newPost) {
        listofPosts.add(newPost);
        return getPost(newPost.getId());
    }

    @Override
    public boolean deletePost(String id) {
        listofPosts.removeIf(post -> post.getId().equals(id));
        return true;
    }

    @Override
    public Post editPost(Post editPost) {
        deletePost(editPost.getId());
        addPost(editPost);
        return getPost(editPost.getId());
    }

    @Override
    public List getPostsByTag(String tag) {
        return listofPosts.stream().filter(post -> post.getTag().matches(tag)).collect(Collectors.toList());
    }
}
