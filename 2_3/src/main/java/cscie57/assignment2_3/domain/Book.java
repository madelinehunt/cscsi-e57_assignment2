package cscie57.assignment2_3.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
// queries
@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name=Book.FIND_ALL, query="select b from Book b")
        ,@NamedQuery(name=Book.FIND_BOOK_WITH_AUTHOR_CATEGORIES,
                query="select distinct b from Book b " +
                        "left join fetch b.category c " +
                        "left join fetch b.authors a")
        ,@NamedQuery(name=Book.FIND_BOOK_BY_ID_W_AUTHOR_CATEGORIES,
                query="select distinct b from Book b " +
                        "left join fetch b.category c " +
                        "left join fetch b.authors a " +
                        "where b.id = :id")
        ,@NamedQuery(name=Book.FIND_BOOK_CATEGORIES_BY_AUTHOR_ID,
                query="select distinct b from Book b " +
                        "left join fetch b.category c " +
                        "left join fetch b.authors a " +
                        "where a.id = :authorId")
})
@SqlResultSetMapping(
     name="bookResult",
     entities=@EntityResult(entityClass=Book.class)
)
public class Book implements Serializable {
    public static final String FIND_ALL = "Book.findAll";
    public static final String FIND_BOOK_WITH_AUTHOR_CATEGORIES = "Book.findBookWithAuthorCategories";
    public static final String FIND_BOOK_BY_ID_W_AUTHOR_CATEGORIES = "Book.findBookByIdWithAuthorCategories";
    public static final String FIND_BOOK_CATEGORIES_BY_AUTHOR_ID = "Book.findBookByAuthorId";
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
    
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    
    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
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
    
    @Override
    public String toString() {
        return "Book - Id: " + id + ", Category ID: " + category.getId() + ", ISBN: " + isbn  + ", Title: " + title + ", Price: " + price;
    }
}
