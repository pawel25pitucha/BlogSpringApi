package com.BlogApi.BlogApi.Controllers;
import com.BlogApi.BlogApi.Models.Mappers.PostDtoToPost;
import com.BlogApi.BlogApi.Models.Post;
import com.BlogApi.BlogApi.Models.ModelsDto.PostDto;
import com.BlogApi.BlogApi.Services.Post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@CrossOrigin(origins="http://localhost:3000")
public class PostController {
    private final IPostService service;
    private final PostDtoToPost postDtoToPost;


    @Autowired
    public PostController(IPostService postService, PostDtoToPost postDtoToPost) {
        this.service=postService;
        this.postDtoToPost = postDtoToPost;
    }

    @GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }
    @GetMapping("/posts/get")
    public List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @GetMapping("/posts/get{id}")
    public Post getPost(@PathVariable String id) {
        return service.getPost(id);
    }

    @GetMapping("/posts/tag/{tag}")
    public List<Post> getPostByTag(@PathVariable String tag) {
        return service.getPostByTag(tag);
    }


    @PostMapping("/posts/add")
    public Post addPost(@Valid @RequestBody PostDto newPost){

       Post post = postDtoToPost.convertPostDtoToPost(newPost);

       return service.addPost(post);
    }
    @PostMapping("/post/edit")
    public Post editPost(@Valid  @RequestBody Post editPost){
        return service.editPost(editPost);
    }
    @DeleteMapping("/post{id}/delete")
    public boolean deletePost(@PathVariable String id){
        return service.deletePost(id);
    }
}
