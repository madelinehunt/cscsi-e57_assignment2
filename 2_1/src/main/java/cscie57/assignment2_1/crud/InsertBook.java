package cscie57.assignment2_1.crud;

import java.sql.Types;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertBook extends SqlUpdate {
    private static final String SQL_INSERT_BOOK =
        "insert into book (category_id, isbn, title, price) values (:categoryId, :isbn, :title, :price)";

    public InsertBook(DataSource dataSource) {        //  throws SQLException
        super(dataSource, SQL_INSERT_BOOK);
        super.declareParameter(new SqlParameter("categoryId", Types.INTEGER));
        super.declareParameter(new SqlParameter("isbn", Types.VARCHAR));
        super.declareParameter(new SqlParameter("title", Types.VARCHAR));
        super.declareParameter(new SqlParameter("price", Types.DECIMAL));
        super.setGeneratedKeysColumnNames(new String[] {"id"});
        super.setReturnGeneratedKeys(true);
    }

}
