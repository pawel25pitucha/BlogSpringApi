package com.BlogApi.BlogApi.Controllers;

import com.BlogApi.BlogApi.Models.AuthorStats;
import com.BlogApi.BlogApi.Models.ModelsDto.AuthorDto;
import com.BlogApi.BlogApi.Models.Mappers.AuthorDtoToAuthor;
import com.BlogApi.BlogApi.Services.Author.IAuthorService;
import com.BlogApi.BlogApi.Models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@CrossOrigin(origins="http://localhost:3000")
public class AuthorController{
    private final IAuthorService service;
    private final AuthorDtoToAuthor authorDtoToAuthor;

    @Autowired
    public AuthorController(IAuthorService authorService, AuthorDtoToAuthor authorDtoToAuthor) {
        this.service=authorService;
        this.authorDtoToAuthor = authorDtoToAuthor;
    }
    @GetMapping("/authors/get")
    public List<Author> getAllAuthors() {
        return service.getAllAuthors();
    }
    @GetMapping("/authors/getByName{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return service.getAuthorByName(name);
    }

    @GetMapping("/authors/get{id}")
    public Author getAuthor(@PathVariable String id) {
        return service.getAuthor(id);
    }

    @PostMapping("/authors/add")
    @ResponseBody
    public Author addAuthor(@Valid @RequestBody AuthorDto newAuthor){
        Author author = authorDtoToAuthor.convertAuthorDtoToAuthor(newAuthor);
        return service.addAuthor(author);

    }
    @PostMapping("authors/edit")
    public boolean aditAuthor(@Valid @RequestBody Author newAuthor ){
        return service.editAuthor(newAuthor);
    }

    @GetMapping("/authors{authorId}/stats")
    public AuthorStats getAuthorsStats(@PathVariable String authorId){
       return service.getAuthorsStats(authorId);
    }
}
