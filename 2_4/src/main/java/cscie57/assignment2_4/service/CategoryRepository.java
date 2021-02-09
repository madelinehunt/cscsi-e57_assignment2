package cscie57.assignment2_4.service;

import java.util.List;

import cscie57.assignment2_4.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {}
