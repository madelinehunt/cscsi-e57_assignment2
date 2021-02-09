package cscie57.assignment2_3.service;

import cscie57.assignment2_3.domain.*;

import java.util.List;

public interface PublishingService {
    public List<Book> findAll();
    public List<Book> findAllWAuthorsCategories();
    public Book findByIdWAuthorsCategories(Long id);
    // public List<Book> findBookCategoriesByAuthor(Long authorId);
    public Book saveBook(Book book);
    public Author saveAuthor(Author author);
    public void deleteBook(Book book);
    public void deleteAuthor(Author author);
    // public void delete(Book book);
    public Category findCategoryById(Long id);
    public List<Book> findAllByNativeQuery();
}
