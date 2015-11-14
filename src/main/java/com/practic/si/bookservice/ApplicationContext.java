package com.practic.si.bookservice;

import com.practic.si.bookservice.domain.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.PollableChannel;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: swatimhankare
 * Date: 11/14/15
 * Time: 2:42 PM
 */
@Configuration
@ComponentScan("com.practic.si.bookservice.endpoint")
@IntegrationComponentScan("com.practic.si.bookservice.gateway")
public class ApplicationContext {
    @Bean
    public HashMap<Integer, Book> allBooks() {
        HashMap<Integer, Book> books = new HashMap<>();
        for ( int i = 1; i <=10; i++) {
            books.put(i, new Book(i, "Book - " + i, "Author - " + i, i * 100));
        }
        return books;
    }
      @Bean
    public DirectChannel bookGetChannel() {
        return new DirectChannel();
    }
      @Bean
    public DirectChannel bookUpdateChannel() {
        return new DirectChannel();
    }
      @Bean
    public DirectChannel bookRemoveChannel() {
        return new DirectChannel();
    }
      @Bean
    public DirectChannel bookAddChannel() {
        return new DirectChannel();
    }
      @Bean
    public DirectChannel bookChannel() {
        return new DirectChannel();
    }
    @Bean
    public DirectChannel errorChannel() {
        return new DirectChannel();
    }

    @Bean
      public PollableChannel bookResponseChannel() {
          return new QueueChannel();
      }
}
