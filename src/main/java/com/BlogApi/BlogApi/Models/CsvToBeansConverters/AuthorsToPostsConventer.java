package com.BlogApi.BlogApi.Models.CsvToBeansConverters;

import com.BlogApi.BlogApi.Models.Author;
import com.BlogApi.BlogApi.Models.AuthorsToPosts;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.Data;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorsToPostsConventer {
    private List<AuthorsToPosts> authorsToPostsList;

    @Data
    class Helper{
        private int post_Id;
        private String author_Id;
        Helper(int post_Id, String author_Id){
            this.author_Id=author_Id;
            this.post_Id=post_Id;
        }
    }

    public AuthorsToPostsConventer() throws IOException, CsvValidationException {

        List<Author> authorsList= new AuthorsFromPostsToBeansConverter().getAuthorsBeans();
        List<Helper> list = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/ManyPostsManyAuthors.csv"));
        CSVReader csvreader= new CSVReader(reader);
        String[] st;
        while((st=csvreader.readNext()) != null){
            String s= st[1];
            for(Author author : authorsList){
                //System.out.println(s+author.getName());
                if(s.matches(".*"+author.getName()+".*")){
                    list.add(new Helper(Integer.parseInt(st[0]), author.getId()));
                }
            }

        }
        reader.close();

        try (
                Writer writer = Files.newBufferedWriter(Paths.get("src\\main\\resources\\AuthorsToPosts.csv"));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END)
        ) {
            String[] headerRecord = {"postId", "authorId"};
            csvWriter.writeNext(headerRecord);


            for(Helper s : list){
                csvWriter.writeNext(new String[]{String.valueOf(s.post_Id), String.valueOf(s.author_Id)});
            }
        }

        try (
                Reader readerr = Files.newBufferedReader(Paths.get("src\\main\\resources\\AuthorsToPosts.csv"))
        ){
            CsvToBean csvToBean = new CsvToBeanBuilder(readerr).withType(AuthorsToPosts.class).withSeparator(',').withIgnoreLeadingWhiteSpace(true).build();
            this.authorsToPostsList=csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
