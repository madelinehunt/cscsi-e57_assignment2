package cscie57.assignment2_1.dao;

import cscie57.assignment2_1.crud.*;
import cscie57.assignment2_1.dao.CategoryDao;
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

@Repository("categoryDao")
public class Two1CategoryDao implements CategoryDao {

    private static Logger logger = LoggerFactory.getLogger(Two1CategoryDao.class);
    private DataSource dataSource;
    
    private SelectAllCategories selectAllCategories;

    @Override
    public List<Category> findAll() {
        return selectAllCategories.execute();
    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllCategories = new SelectAllCategories(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
