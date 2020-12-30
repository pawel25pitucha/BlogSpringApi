package com.BlogApi.BlogApi.Repositories.Author;

import com.BlogApi.BlogApi.Models.Author;
import com.BlogApi.BlogApi.Models.CsvToBeansConverters.AuthorsFromPostsToBeansConverter;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class AuthorRepository implements IAuthorRepository {
    private final List<Author> authorsList;

    public AuthorRepository() throws IOException, CsvValidationException {
        this.authorsList= new AuthorsFromPostsToBeansConverter().getAuthorsBeans();
    }
    @Override
    public List<Author> getAllAuthors() {
        return authorsList;
    }

    @Override
    public Author getAuthor(String id) {
        return authorsList.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Author getAuthorByName(String name) {
      return authorsList.stream().filter(author -> author.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Author addAuthor(Author newAuthor) {
        Author check = getAuthorByName(newAuthor.getName());
        if(check==null){
            authorsList.add(newAuthor);
            return getAuthor(newAuthor.getId());
        }else {
            System.out.println("ZNALAZLEM TAKIEGO AUTORA");
            return check;
        }

    }

    @Override
    public boolean editAuthor(Author newAuthor) {
        deleteAuthor(newAuthor.getId());
        authorsList.add(newAuthor);
        return true;
    }

    @Override
    public boolean deleteAuthor(String id) {
        authorsList.removeIf(author -> author.getId().equals(id));
        return true;
    }
}
