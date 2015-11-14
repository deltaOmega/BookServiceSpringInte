package com.practic.si.bookservice;

import com.practic.si.bookservice.domain.Book;
import com.practic.si.bookservice.gateway.BookServiceMessagingGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.Gateway;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: swatimhankare
 * Date: 11/14/15
 * Time: 2:50 PM
 */
@RestController
@RequestMapping("/books")
public class BookServiceController {
    @Autowired
    BookServiceMessagingGateway gateway;

    @RequestMapping("/book/{id}")
    public Book getBook(@PathVariable Integer id) {
        return gateway.getBook(id)        ;

    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return gateway.addBook(book)   ;

    }
    @RequestMapping(value = "/book/remove/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book removeBook(@PathVariable Integer id) {
        return gateway.removeBook(id)   ;

    }
    @RequestMapping(value = "/book/update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book updateBook(@RequestBody Book book) {
        return gateway.updateBook(book)   ;

    }
}
