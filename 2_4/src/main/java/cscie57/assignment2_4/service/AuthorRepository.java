package cscie57.assignment2_4.service;

import java.util.List;

import cscie57.assignment2_4.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
