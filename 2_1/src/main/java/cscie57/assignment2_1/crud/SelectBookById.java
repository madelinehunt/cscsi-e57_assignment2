package cscie57.assignment2_1.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import cscie57.assignment2_1.domain.Category;
import cscie57.assignment2_1.domain.Book;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.core.SqlParameter;

public class SelectBookById extends MappingSqlQuery<Book> {
    private static final String SQL_FIND_BOOK_BY_ID = "select * from book where id=:id;";

    public SelectBookById(DataSource dataSource) {
        super(dataSource, SQL_FIND_BOOK_BY_ID);
        super.declareParameter(new SqlParameter("id", Types.VARCHAR));
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
