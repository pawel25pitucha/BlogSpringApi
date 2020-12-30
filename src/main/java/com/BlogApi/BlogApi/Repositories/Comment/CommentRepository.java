package com.BlogApi.BlogApi.Repositories.Comment;

import com.BlogApi.BlogApi.Models.Comment;
import com.BlogApi.BlogApi.Models.CsvToBeansConverters.CommentsCsvToBeansConventer;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentRepository implements ICommentRepository{
    private final List<Comment> commentList;

    public CommentRepository() throws FileNotFoundException {
        this.commentList=new CommentsCsvToBeansConventer().getCommentsBeans();
    }

    @Override
    public List<Comment> getAllComments(){
        System.out.println("Get all comments method REPOSITORY");
        return commentList;
    }

    @Override
    public Comment getComment(String id) {
        return commentList.stream().filter(comment -> comment.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Comment addComment(Comment newComment) {
        commentList.add(newComment);
        return getComment(newComment.getId());
    }

    @Override
    public boolean deleteComment(String id) {
        commentList.removeIf(comment -> comment.getId().equals(id));
        return true;
    }

    @Override
    public boolean deleteAllCommentsFromPost(String id) {
        commentList.removeIf(comment -> comment.getPostId().equals(id));
        return true;
    }

    @Override
    public Comment editComment(Comment newComment) {
        deleteComment(newComment.getId());
        addComment(newComment);
        return getComment(newComment.getId());
    }

    @Override
    public List<Comment> getPostComments(String id) {
        return commentList.stream().filter(x->x.getPostId().equals(id)).collect(Collectors.toList());
    }
    @Override
    public List<Comment> getAuthorComments(String name) {
        return commentList.stream().filter(x->x.getUsername().equals(name)).collect(Collectors.toList());
    }

}
