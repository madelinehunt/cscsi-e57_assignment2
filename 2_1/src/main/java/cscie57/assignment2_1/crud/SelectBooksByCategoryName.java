package cscie57.assignment2_1.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import cscie57.assignment2_1.domain.Category;
import cscie57.assignment2_1.domain.Book;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.core.SqlParameter;

public class SelectBooksByCategoryName extends MappingSqlQuery<Book> {
    private static final String SQL_FIND_BOOKS_BY_CATEGORY_NAME = "select" +
    " id, category_id, isbn, title, price" +
    " from book where category_id in (" +
            " select id" +
            " from CATEGORY " +
            " where name=:categoryName" +
        ");";

    public SelectBooksByCategoryName(DataSource dataSource) {
        super(dataSource, SQL_FIND_BOOKS_BY_CATEGORY_NAME);
        super.declareParameter(new SqlParameter("categoryName", Types.VARCHAR));
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
