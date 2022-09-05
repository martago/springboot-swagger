package com.example.springbootswagger.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@ApiModel(value = "BookDTO", description = "A simple book entity")
public class BookDTO {
    @ApiModelProperty(value = "The bookId of the book.", example = "200")
    private String bookId;

    @ApiModelProperty(value = "The bookname", example = "A small village")
    private String bookName;
}
