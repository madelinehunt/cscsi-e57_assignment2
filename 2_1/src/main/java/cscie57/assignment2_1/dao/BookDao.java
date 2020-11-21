package cscie57.assignment2_1.dao;

import cscie57.assignment2_1.domain.Book;

import java.util.List;

public interface BookDao {
    public List<Book> findAll();
    public List<Book> findByCategoryName(String categoryName);
    public Book findById(Long id);
    public void insert(Book book);
    public void updatePrice(Long bookId, Double newPrice);
    public void delete(Long bookId);
}