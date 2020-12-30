package com.BlogApi.BlogApi.Repositories.Comment;

import com.BlogApi.BlogApi.Models.Comment;

import java.util.List;
import java.util.stream.Stream;

public interface ICommentRepository {
    List<Comment> getAllComments();
    Comment getComment(String id);

    Comment addComment(Comment newComment);

    boolean deleteComment(String id);
    boolean deleteAllCommentsFromPost(String id);

    Comment editComment(Comment newComment);

    List getPostComments( String id);
    List getAuthorComments( String name);

}
