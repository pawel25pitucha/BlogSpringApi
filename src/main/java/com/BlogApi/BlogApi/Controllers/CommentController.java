package com.BlogApi.BlogApi.Controllers;

import com.BlogApi.BlogApi.Models.Comment;
import com.BlogApi.BlogApi.Models.Mappers.CommentDtoToComment;
import com.BlogApi.BlogApi.Models.ModelsDto.CommentDto;
import com.BlogApi.BlogApi.Services.Comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@CrossOrigin(origins="http://localhost:3000")
public class CommentController {
    private final ICommentService service;

    private final CommentDtoToComment commentDtoToComment;

    @Autowired
    public CommentController(ICommentService commentService, CommentDtoToComment commentDtoToComment) {
        this.service=commentService;
        this.commentDtoToComment = commentDtoToComment;
    }

    @GetMapping("/comments/get")
    public List<Comment> getAllComments() {
        System.out.println("get all comments method CONTROLLER");
        return service.getAllComments();
    }

    @GetMapping("/comments/get{id}")
    public Comment getComment(@PathVariable String id) {
        return service.getComment(id);
    }

    @GetMapping("/post{id}/comments")
    public List<Comment>  getPostComments(@PathVariable String id){
        return service.getPostComments(id);
    }

    @PostMapping("/comments/add")
    public Comment addComment(@Valid @RequestBody CommentDto newComment){
        Comment comment = commentDtoToComment.convertCommentDtoToComment(newComment);
        return service.addComment(comment);
    }

    @PostMapping("/comments/edit")
    public Comment editComment(@Valid @RequestBody Comment newComment){
        return service.editComment(newComment);
    }

    @DeleteMapping("/comment{id}/delete")
    public boolean deleteComment(@PathVariable String id){
       return service.deleteComment(id);
    }



}

