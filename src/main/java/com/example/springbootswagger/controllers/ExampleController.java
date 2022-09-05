package com.example.springbootswagger.controllers;

import com.example.springbootswagger.configurations.SwaggerConfig;
import com.example.springbootswagger.dtos.BookDTO;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Api(tags = {SwaggerConfig.EXAMPLE_TAG})
public class ExampleController {

    @GetMapping("/sayHello")
    @ApiOperation(value = "This method is used to get the author name.", notes = "To say hello to you, we need your firstname.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully says hello to you")
    })
    public String sayHello(@RequestParam(name = "name") String yourName) {
        return String.format("Hello %s!", yourName);
    }

    @GetMapping("/book/{id}")
    @ApiOperation(value = "This method is used to get the name of your book.", notes = "For the search you need a bookId.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully load a book"),
            @ApiResponse(code = 400, message = "You send an invalid bookId"),
            @ApiResponse(code = 404, message = "Your book could not be found")
    })
    public String getBookName(@PathVariable("id") String bookId) {
        // Guard check
        if (StringUtils.isEmpty(bookId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This is not a valid bookId!");
        }

        // search the book
        if ("100".equals(bookId)) {
            return "A cold winter";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the book could not be found!");
    }

    @GetMapping("/bookfile/{id}")
    @ApiOperation(value = "This method is to get the compelete book", notes = "For the search you need a bookId.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully load a book"),
            @ApiResponse(code = 400, message = "You send an invalid bookId"),
            @ApiResponse(code = 404, message = "Your book could not be found")
    })
    public BookDTO getBookFile(@PathVariable("id") String bookId) {
        // Guard check
        if (StringUtils.isEmpty(bookId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This is not a valid bookId!");
        }

        // search the book
        if ("100".equals(bookId)) {
            return new BookDTO("100", "A cold winter");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the book could not be found!");
    }
}
