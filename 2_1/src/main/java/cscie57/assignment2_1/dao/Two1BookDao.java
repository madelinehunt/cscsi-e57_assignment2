package cscie57.assignment2_1.dao;

import cscie57.assignment2_1.crud.*;
import cscie57.assignment2_1.dao.BookDao;
import cscie57.assignment2_1.domain.Book;
import cscie57.assignment2_1.domain.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("bookDao")
public class Two1BookDao implements BookDao {

    private static Logger logger = LoggerFactory.getLogger(Two1BookDao.class);
    private DataSource dataSource;
    
    private SelectAllBooks selectAllBooks;
    private SelectBooksByCategoryName selectBooksByCategoryName;
    private SelectBookById selectBookById;
    private InsertBook insertBook;
    private DeleteBook deleteBook;
    private UpdateBook updateBook;

    @Override
    public List<Book> findAll() {
        return selectAllBooks.execute();
    }

    @Override
    public List<Book> findByCategoryName(String categoryName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("categoryName", categoryName);
        return selectBooksByCategoryName.executeByNamedParam(paramMap);
    }
    
    @Override
    public Book findById(Long id) {
        Map<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("id", id);
        List<Book> books = selectBookById.executeByNamedParam(queryParamMap);
        // this should be a list of length 1, grab the only element
        return books.get(0);
    }

    @Override
    public void insert(Book book) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("categoryId", book.getCategoryId());
        paramMap.put("isbn", book.getISBN());
        paramMap.put("title", book.getTitle());
        paramMap.put("price", book.getPrice());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertBook.updateByNamedParam(paramMap, keyHolder);
        book.setId(keyHolder.getKey().longValue());
        logger.info("New book inserted with id: " + book.getId());
    }

    @Override
    public void updatePrice(Long bookId, Double newPrice) {
        // queries for the book first
        Map<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("id", bookId);
        List<Book> books = selectBookById.executeByNamedParam(queryParamMap);
        // this should be a list of length 1, grab the only element
        Book book = books.get(0);
        
        // uses generalized update method to update price
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", book.getId());
        paramMap.put("categoryId", book.getCategoryId());
        paramMap.put("isbn", book.getISBN());
        paramMap.put("title", book.getTitle());
        paramMap.put("price", newPrice);
        updateBook.updateByNamedParam(paramMap);
        logger.info("Existing book updated with id: " + bookId);
    }
    
    
    @Override public void delete(Long bookId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", bookId);
        deleteBook.updateByNamedParam(paramMap);
        logger.info("Deleting book with id: " + bookId);
    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllBooks = new SelectAllBooks(dataSource);
        this.selectBooksByCategoryName = new SelectBooksByCategoryName(dataSource);
        this.selectBookById = new SelectBookById(dataSource);
        this.insertBook = new InsertBook(dataSource);
        this.deleteBook = new DeleteBook(dataSource);
        this.updateBook = new UpdateBook(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
