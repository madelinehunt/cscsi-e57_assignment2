package cscie57.assignment2_4.service;

import cscie57.assignment2_4.domain.*;

import java.util.List;

public interface PublishingService {
    public List<Book> findAll();
    public Book findById(Long id);
    public Category findCategoryById(Long id);
    public Book saveBook(Book book);
    public Author saveAuthor(Author author);
    public void deleteBook(Book book);
    public void deleteAuthor(Author author);
}
