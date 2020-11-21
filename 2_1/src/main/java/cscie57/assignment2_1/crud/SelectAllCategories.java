package cscie57.assignment2_1.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import cscie57.assignment2_1.domain.Category;
import org.springframework.jdbc.object.MappingSqlQuery;

public class SelectAllCategories extends MappingSqlQuery<Category> {
    private static final String SQL_SELECT_ALL_CATEGORIES =
        "select id, name from category";

    public SelectAllCategories(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_CATEGORIES);
    }

    protected Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getLong("id"));
        category.setName(rs.getString("name"));

        return category;
    }
}
