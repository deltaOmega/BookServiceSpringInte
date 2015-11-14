package com.practic.si.bookservice.endpoint;

import com.practic.si.bookservice.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: swatimhankare
 * Date: 11/14/15
 * Time: 2:34 PM
 */
@Service
public class BookService {
    @Autowired
    HashMap<Integer, Book> allBooks;

    @ServiceActivator(inputChannel = "bookGetChannel", outputChannel = "bookResponseChannel", requiresReply = "true")
    public Book getBook(Integer id) {
        Book book = allBooks.get(id);
        return book;
    }

    @ServiceActivator(inputChannel = "bookRemoveChannel", outputChannel = "bookResponseChannel", requiresReply = "true")
    public Book removeBook(Integer bookId) {
        Book removedBook = allBooks.remove(bookId);
        return removedBook;
    }

    @ServiceActivator(inputChannel = "bookUpdateChannel", outputChannel = "bookResponseChannel", requiresReply = "true")
    public Book updateBook(Book book) {
        Book updatedBook = allBooks.put(book.getId(), book) ;
        return updatedBook;
    }
    @ServiceActivator(inputChannel = "bookAddChannel", outputChannel = "bookResponseChannel", requiresReply = "true")
    public Book addBook(Book book) {
        Book addedBook = allBooks.put(book.getId(), book);
        return addedBook;
    }
}
