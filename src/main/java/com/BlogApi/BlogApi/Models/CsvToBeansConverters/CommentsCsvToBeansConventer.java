package com.BlogApi.BlogApi.Models.CsvToBeansConverters;

import com.BlogApi.BlogApi.Models.Comment;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class CommentsCsvToBeansConventer {

    private List<Comment> commentsBeans;

    public CommentsCsvToBeansConventer(){
        try (
                Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/Comments.csv"))
        ) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(Comment.class).withIgnoreLeadingWhiteSpace(true).build();


           this.commentsBeans=csvToBean.parse();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Comment> getCommentsBeans(){
        return commentsBeans;
    }
}

