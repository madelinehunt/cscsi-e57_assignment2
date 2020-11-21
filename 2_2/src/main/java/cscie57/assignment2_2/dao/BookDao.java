package cscie57.assignment2_2.dao;

import cscie57.assignment2_2.domain.Book;

import java.util.List;

public interface BookDao {
    public List<Book> findAll();
    public List<Book> findAllWAuthorsCategories();
    public Book findByIdWAuthorsCategories(Long id);
    public List<Book> findBookCategoriesByAuthor(Long authorId);
    public Book save(Book book);
    public void delete(Book book);
}
