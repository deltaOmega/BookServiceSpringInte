package com.practic.si.bookservice.domain;
/**
 * Created by IntelliJ IDEA.
 * User: swatimhankare
 * Date: 11/14/15
 * Time: 2:32 PM
 */
public class Book {

    private Integer id;
    private String name;
    private String author;
    private double price;

    public Book()  {

    }
    public Book(Integer id, String name, String author, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
