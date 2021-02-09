package cscie57.assignment2_4.service;

import cscie57.assignment2_4.service.*;
import cscie57.assignment2_4.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.google.common.collect.Lists;

@Service("publishingService")
@Transactional
public class PublishingServiceImpl implements PublishingService {
    private static Logger logger = LoggerFactory.getLogger(PublishingServiceImpl.class);
    
    @Autowired
    private BookRepository bookRepo;
    
    @Autowired
    private AuthorRepository authorRepo;
    
    @Autowired
    private CategoryRepository categoryRepo;

    @Transactional(readOnly=true)
    public List<Book> findAll() {
        return Lists.newArrayList(bookRepo.findAll());
    }
    
    @Transactional(readOnly=true)
    public Book findById(Long id) {
        return bookRepo.findById(id).get();
    }
    
    public Category findCategoryById(Long id){
        return categoryRepo.findById(id).get();
    }
    
    public Book saveBook(Book book){
        return bookRepo.save(book);
    }
    
    public Author saveAuthor(Author author){
        return authorRepo.save(author);
    }
    
    public void deleteBook(Book book){
        bookRepo.delete(book);
    }
    
    public void deleteAuthor(Author author){
        authorRepo.deleteById(author.getId());
    }

}
