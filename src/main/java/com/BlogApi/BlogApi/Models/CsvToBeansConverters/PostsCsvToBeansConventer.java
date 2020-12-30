package com.BlogApi.BlogApi.Models.CsvToBeansConverters;

import com.BlogApi.BlogApi.Models.Post;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class PostsCsvToBeansConventer {

    private List<Post> postsBeans;


    public PostsCsvToBeansConventer(){
       /* Path path = Paths.get("src\\main\\resources\\ManyPostsManyAuthors.csv");
        Charset charset = StandardCharsets.UTF_8;

        String content = Files.readString(path, charset);
        content = content.replaceAll("[{]\"{2}authors\"{2}[:]", "");
        content = content.replaceAll("[}]", "");
        content = content.replaceAll("\"{2}", "\"");


        Files.writeString(path, content, charset);

*/
        try (
                Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/ManyPostsManyAuthors.csv"))
        ) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader).withSeparator(',').withType(Post.class).withIgnoreLeadingWhiteSpace(true).build();
            this.postsBeans=csvToBean.parse();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public List<Post> getPostsBeans(){
        return postsBeans;
    }
}

