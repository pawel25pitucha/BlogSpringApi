package com.BlogApi.BlogApi.Services.Comment;

import com.BlogApi.BlogApi.Models.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> getAllComments();
    Comment getComment(String id);
    Comment addComment(Comment newComment);

    boolean deleteComment(String id);

    Comment editComment(Comment newComment);
    List getPostComments(String id);
}
