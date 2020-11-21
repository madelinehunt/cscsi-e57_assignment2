package cscie57.assignment2_3.service;

import cscie57.assignment2_3.domain.Book;

import java.util.List;

public interface PublishingService {
    public List<Book> findAll();
    public List<Book> findAllWAuthorsCategories();
    public Book findByIdWAuthorsCategories(Long id);
    // public List<Book> findBookCategoriesByAuthor(Long authorId);
    // public Book save(Book book);
    // public void delete(Book book);
    public List<Book> findAllByNativeQuery();
}
