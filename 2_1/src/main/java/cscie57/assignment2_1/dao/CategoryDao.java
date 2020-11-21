package cscie57.assignment2_1.dao;

import cscie57.assignment2_1.domain.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> findAll();
}