package cscie57.assignment2_4.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Book> books = new HashSet<>();
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public Set<Book> getBooks(){
        return books;
    }
    
    public void setBooks(Set<Book> books){
        this.books = books;
    }

    public boolean addBook(Book book){
        book.setCategory(this);
        return books.add(book);
    }
    
    public void removeBook(Book book){
        books.remove(book);
    }

    @Override
    public String toString() {
        return "Category - Id: " + id + ", Name: " + name;
    }
}
