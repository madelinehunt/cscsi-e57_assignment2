package cscie57.assignment2_2.dao;

import cscie57.assignment2_2.domain.Category;

import java.util.List;

public interface CategoryDao {
    public Category findById(Long id);
    public List<Category> findAll();
}
