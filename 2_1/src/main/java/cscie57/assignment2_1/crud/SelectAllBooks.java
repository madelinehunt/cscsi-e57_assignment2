package cscie57.assignment2_1.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import cscie57.assignment2_1.domain.Book;
import org.springframework.jdbc.object.MappingSqlQuery;

public class SelectAllBooks extends MappingSqlQuery<Book> {
    private static final String SQL_SELECT_ALL_BOOKS =
        "select id, category_id, isbn, title, price from book";

    public SelectAllBooks(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_BOOKS);
    }

    protected Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setCategoryId(rs.getLong("category_id"));
        book.setISBN(rs.getString("isbn"));
        book.setTitle(rs.getString("title"));
        book.setPrice(rs.getDouble("price"));

        return book;
    }
}
