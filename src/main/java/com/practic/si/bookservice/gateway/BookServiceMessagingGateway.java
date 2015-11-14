package com.practic.si.bookservice.gateway;

import com.practic.si.bookservice.domain.Book;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by IntelliJ IDEA.
 * User: swatimhankare
 * Date: 11/14/15
 * Time: 2:30 PM
 */
@MessagingGateway(defaultRequestChannel = "bookChannel",
        defaultReplyChannel = "bookResponseChannel")
public interface BookServiceMessagingGateway {
    @Gateway(headers = @GatewayHeader(name="MESSAGE_TYPE", value="ADDBOOK"))
    public Book addBook(Book book);

    @Gateway(headers = @GatewayHeader(name="MESSAGE_TYPE", value="UPDATEBOOK"))
    public Book updateBook(Book book);

    @Gateway(headers = @GatewayHeader(name="MESSAGE_TYPE", value="REMOVEBOOK"))
    public Book removeBook(Integer id);

    @Gateway(headers = @GatewayHeader(name="MESSAGE_TYPE", value="GETBOOK"))
    public Book getBook(Integer id);

}
