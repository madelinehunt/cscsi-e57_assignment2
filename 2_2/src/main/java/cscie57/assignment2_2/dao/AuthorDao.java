package cscie57.assignment2_2.dao;

import cscie57.assignment2_2.domain.Author;

import java.util.List;

public interface AuthorDao {
    public Author findById(Long id);
    public List<Author> findAll();
    public Author save(Author author);
    public void delete(Author author);
}
