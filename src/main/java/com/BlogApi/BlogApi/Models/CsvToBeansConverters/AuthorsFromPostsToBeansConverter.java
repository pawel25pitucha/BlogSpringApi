package com.BlogApi.BlogApi.Models.CsvToBeansConverters;

import com.BlogApi.BlogApi.Models.Author;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorsFromPostsToBeansConverter {
    private List<Author> authorsBeans;

    public AuthorsFromPostsToBeansConverter() throws IOException, CsvValidationException {

        List<String> list = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/ManyPostsManyAuthors.csv"));
        CSVReader csvreader= new CSVReader(reader);
        String[] st;
        while((st=csvreader.readNext()) != null){
            char[] s= st[1].toCharArray();
            StringBuilder author= new StringBuilder();
            for(int i=0 ; i<s.length ; i++){
                char ch = s[i];
                if(ch!='[' && ch!=']'&& ch!='"' && ch!=','){
                    author.append(ch);
                }
                if(i+1 <s.length){
                    if(ch==',' || s[i+1]==']'){
                        if(!list.contains(author.toString())) list.add(author.toString());
                        author = new StringBuilder();
                    }
                }

            }
        }
        reader.close();
        try (
                Writer writer = Files.newBufferedWriter(Paths.get("src\\main\\resources\\authors.csv"));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END)
        ) {
            String[] headerRecord = {"Id", "Name"};
            csvWriter.writeNext(headerRecord);
            int i =0;

            for(String s : list){
                csvWriter.writeNext(new String[]{String.valueOf(i),s});
                i++;
            }
        }

        try (
                Reader readerr = Files.newBufferedReader(Paths.get("src\\main\\resources\\authors.csv"))
        ){
            CsvToBean csvToBean = new CsvToBeanBuilder(readerr).withType(Author.class).withIgnoreLeadingWhiteSpace(true).build();
            this.authorsBeans=csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
