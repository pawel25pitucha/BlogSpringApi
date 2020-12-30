package com.BlogApi.BlogApi.Repositories.AuthorsToPosts;
import com.BlogApi.BlogApi.Models.AuthorsToPosts;
import com.BlogApi.BlogApi.Models.CsvToBeansConverters.AuthorsToPostsConventer;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class AuthorsToPostsRepository implements IAuthorsToPostsRepository {
    private final List<AuthorsToPosts> authorsToPostsList;

    public AuthorsToPostsRepository() throws IOException, CsvValidationException {
        this.authorsToPostsList=new AuthorsToPostsConventer().getAuthorsToPostsList();
    }
    @Override
    public List<AuthorsToPosts> getAllAuthorPosts(String id)
    {
        return authorsToPostsList.stream().filter(x -> x.getAuthorId().equals(id)).collect(Collectors.toList());  //return list with authors and posts id where authorId==id.
    }

    @Override
    public List<AuthorsToPosts> getAllPostAuthors(String id) {

        return authorsToPostsList.stream().filter(x -> x.getPostId().equals(id)).collect(Collectors.toList());  //return list with authors and posts id where postId==id.
    }

    @Override
    public boolean deletePost(String id) {
        authorsToPostsList.removeIf(x-> x.getPostId().equals(id));
        return true;
    }

    @Override
    public boolean deleteAuthorFromPost(String authorId, String postId) {
        authorsToPostsList.removeIf(x-> x.getPostId().equals(postId) && x.getAuthorId().equals(authorId));
        return true;
    }



    @Override
    public AuthorsToPosts addPost(String postId, String authorId) {
        AuthorsToPosts check =  authorsToPostsList.stream().filter(x-> x.getPostId().equals(postId) && x.getAuthorId().equals(authorId)).findFirst().orElse(null);
       if(check==null){
           authorsToPostsList.add(new AuthorsToPosts(postId,authorId));
           return authorsToPostsList.stream().filter(x-> x.getPostId().equals(postId) && x.getAuthorId().equals(authorId)).findFirst().orElse(null);
       }else {
           return check;
       }

    }




}
