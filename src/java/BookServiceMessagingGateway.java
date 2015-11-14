package com.practic.si.bookservice.endpoint;

import org.springframework.integration.annotation.MessagingGateway;


/**
 * Created by IntelliJ IDEA.
 * User: swatimhankare
 * Date: 11/14/15
 * Time: 1:39 PM
 */
@MessagingGateway(defaultRequestChannel = "bookChannel", defaultReplyChannel = "bookResponseChannel")
public class BookServiceMessagingGateway {
    public Book addBook(Book book);
    public Book removeBook(Book book);
    public Book updateBook(Book book);
    public Book getBook(Integer id);
}
