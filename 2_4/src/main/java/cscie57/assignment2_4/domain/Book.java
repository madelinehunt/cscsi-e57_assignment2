package cscie57.assignment2_4.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
// queries
@Entity
@Table(name = "book")
public class Book implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "ISBN")
    private String isbn;
    
    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "PRICE")
    private Double price;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID")
            )
    private Set<Author> authors = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return this.category;
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
    
    public Set<Author> getAuthors() {
        return authors;
    }
    
    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public boolean addAuthor(Author author) {
        return authors.add(author);
    }
    
    @PreRemove
    private void removeCategory(){
        this.category.removeBook(this);
    }
    
    @Override
    public String toString() {
        return "Book - Id: " + id + ", Category ID: " + category.getId() + ", ISBN: " + isbn  + ", Title: " + title + ", Price: " + price;
    }
}
