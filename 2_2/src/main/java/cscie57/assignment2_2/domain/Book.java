package cscie57.assignment2_2.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

// queries
@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name=Book.FIND_BOOK_WITH_AUTHOR_CATEGORIES,
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

public class Book extends AbstractDomain {
    public static final String FIND_BOOK_WITH_AUTHOR_CATEGORIES = "Book.findBookWithAuthorCategories";
    public static final String FIND_BOOK_BY_ID_W_AUTHOR_CATEGORIES = "Book.findBookByIdWithAuthorCategories";
    public static final String FIND_BOOK_CATEGORIES_BY_AUTHOR_ID = "Book.findBookByAuthorId";
    
    
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
    
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
            
        Book book = (Book) o;
        if (title != null ? !title.equals(book.title) : book.title != null)
            return false;
        return releaseDate != null ? releaseDate.equals(album.releaseDate) : album.releaseDate == null;
    }
    
    @Override
    public String toString() {
        return "Book - Id: " + id + ", Category ID: " + category.getId() + ", ISBN: " + isbn  + ", Title: " + title + ", Price: " + price;
    }
}
