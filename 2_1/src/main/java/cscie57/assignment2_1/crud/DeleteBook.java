package cscie57.assignment2_1.crud;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class DeleteBook extends SqlUpdate {
    private static final String SQL_DELETE_BOOK =
        "delete from book where id = :id";

    public DeleteBook(DataSource dataSource) {
        super(dataSource, SQL_DELETE_BOOK);
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
    }
}
