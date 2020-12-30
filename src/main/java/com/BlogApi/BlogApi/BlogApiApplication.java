package com.BlogApi.BlogApi;
import com.BlogApi.BlogApi.Models.Author;
import com.BlogApi.BlogApi.Models.CsvToBeansConverters.AuthorsFromPostsToBeansConverter;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class BlogApiApplication {

	public static void main(String[] args) throws IOException, CsvValidationException {
		SpringApplication.run(BlogApiApplication.class, args);
	}

}
