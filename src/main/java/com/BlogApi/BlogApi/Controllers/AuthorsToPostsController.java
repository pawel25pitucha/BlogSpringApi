package com.BlogApi.BlogApi.Controllers;

import com.BlogApi.BlogApi.Models.Author;
import com.BlogApi.BlogApi.Models.AuthorsToPosts;
import com.BlogApi.BlogApi.Models.Post;
import com.BlogApi.BlogApi.Services.AuthorsToPosts.IAuthorsToPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@CrossOrigin(origins="http://localhost:3000")
public class AuthorsToPostsController{
    private final IAuthorsToPostsService service;

    @Autowired
    public AuthorsToPostsController(IAuthorsToPostsService authorsToPostsService) {
        this.service=authorsToPostsService;
    }
    @PostMapping("/post{postId}/addAuthor{authorId}")
    public AuthorsToPosts addAuthorToPost(@PathVariable String postId,@PathVariable String authorId ){
        System.out.println(postId);
        System.out.println(authorId);
        return service.addPostAuthor(postId,authorId);
    }
    @DeleteMapping("/post{postId}/author{authorId}")
    public boolean deleteAuthorFromPost(@PathVariable String postId , @PathVariable String authorId){
        return service.deleteAuthorFromPost(authorId,postId);
    }

    @GetMapping("/author{id}/posts")
    public List<Post> getAllAuthorPosts(@PathVariable  String id) {
       return service.getAllAuthorPosts(id);
    }

    @GetMapping("/post{id}/authors")
    public List<Author> getAllPostAuthors(@PathVariable String id) {
        return service.getAllPostAuthors(id);
    }
}
