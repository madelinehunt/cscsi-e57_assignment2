package cscie57.assignment2_4.service;

import java.util.List;

import cscie57.assignment2_4.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {}
