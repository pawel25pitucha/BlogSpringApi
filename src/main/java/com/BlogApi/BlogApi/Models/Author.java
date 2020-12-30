package com.BlogApi.BlogApi.Models;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @NotNull
    @CsvBindByName(column = "Id")
    private String id;

    @NotEmpty
    @CsvBindByName(column = "Name")
    private String name;
}
