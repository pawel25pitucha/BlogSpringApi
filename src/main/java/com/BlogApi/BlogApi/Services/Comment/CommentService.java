package com.BlogApi.BlogApi.Services.Comment;

import com.BlogApi.BlogApi.Repositories.Comment.ICommentRepository;
import com.BlogApi.BlogApi.Models.Comment;
import com.BlogApi.BlogApi.Repositories.Comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    private final ICommentRepository repository;

    @Autowired
    public CommentService(ICommentRepository commentRepository) {
        this.repository=commentRepository;
    }


    public List<Comment> getAllComments(){
        System.out.println("Get all comments method SERVICE");
        return repository.getAllComments();
    }

    public Comment getComment(String id) {
       return  repository.getComment(id);
    }

    @Override
    public Comment addComment(Comment newComment) {
        return repository.addComment(newComment);
    }

    @Override
    public boolean deleteComment(String id) {
        return repository.deleteComment(id);
    }

    @Override
    public Comment editComment(Comment newComment) {
        return repository.editComment(newComment);
    }

    @Override
    public List<Comment> getPostComments(String id) {
        return repository.getPostComments(id);
    }


}
