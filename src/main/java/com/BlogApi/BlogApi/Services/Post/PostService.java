package com.BlogApi.BlogApi.Services.Post;

import com.BlogApi.BlogApi.Repositories.AuthorsToPosts.IAuthorsToPostsRepository;
import com.BlogApi.BlogApi.Repositories.Comment.ICommentRepository;
import com.BlogApi.BlogApi.Repositories.Post.IPostRepository;
import com.BlogApi.BlogApi.Models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{
    private final IPostRepository repository;
    private final IAuthorsToPostsRepository authorsToPostsRepository;
    private final ICommentRepository commentRepository;

    @Autowired
    public PostService(IPostRepository repository, IAuthorsToPostsRepository authorsToPostsRepository, ICommentRepository commentRepository){
        this.repository=repository;
        this.authorsToPostsRepository=authorsToPostsRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return repository.getAllPosts();
    }

    @Override
    public Post getPost(String id) {
        return repository.getPost(id);
    }

    @Override
    public List<Post> getPostByTag(String tag) {
        return repository.getPostByTag(tag);
    }

    @Override
    public Post addPost(Post newPost) {
        return repository.addPost(newPost);
    }
    @Override
    public boolean deletePost(String id) {
        return repository.deletePost(id) && authorsToPostsRepository.deletePost(id)&&commentRepository.deleteAllCommentsFromPost(id);
    }
    @Override
    public Post editPost( Post editPost) {
        return repository.editPost(editPost);
    }

    @Override
    public List getPostsByTag(String tag) {
        return repository.getPostsByTag(tag);
    }
}
