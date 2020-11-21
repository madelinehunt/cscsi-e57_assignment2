package cscie57.assignment2_2.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "author")
@NamedQueries({
        @NamedQuery(name=Author.FIND_AUTHOR_BY_ID,
                query="select distinct b from Author b " +
                "where id = :id")
})
public class Author extends AbstractDomain {
    public static final String FIND_AUTHOR_BY_ID = "Author.findAuthorById";
    
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private Set<Book> books = new HashSet<>();

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Author - Id: " + id + ", first name: " + firstName + ", last name: " + lastName  + ", Description omitted.";
    }
}
