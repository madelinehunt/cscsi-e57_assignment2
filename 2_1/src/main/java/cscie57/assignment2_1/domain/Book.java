package cscie57.assignment2_1.domain;

import java.io.Serializable;

public class Book implements Serializable {
    private Long id;
    private Long categoryId;
    private String isbn;
    private String title;
    private Double price;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }
    
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getISBN() {
        return this.isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Book - Id: " + id + ", Category ID: " + categoryId + ", ISBN: " + isbn  + ", Title: " + title + ", Price: " + price;
    }
}
