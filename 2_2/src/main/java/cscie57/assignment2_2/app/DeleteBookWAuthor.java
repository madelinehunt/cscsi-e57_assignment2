package cscie57.assignment2_2.app;

import cscie57.assignment2_2.config.AppConfig;
import cscie57.assignment2_2.dao.*;
import cscie57.assignment2_2.domain.*;
import cscie57.assignment2_2.utils.Two2Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Collections; 
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class DeleteBookWAuthor {
    private static Logger logger = LoggerFactory.getLogger(DeleteBookWAuthor.class);

    public static void main(String... args) {
        GenericApplicationContext ctx = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        CategoryDao catDao = ctx.getBean(CategoryDao.class);
        AuthorDao authorDao = ctx.getBean(AuthorDao.class);
        
        // find highest id of books, to guard against any DB changes
        List<Book> books = bookDao.findAllWAuthorsCategories();
        List<Long> ids = books.stream()
            .map(book -> book.getId())
            .collect(Collectors.toList());
        Long idToDelete = Collections.max(ids);
        
        Book book = bookDao.findByIdWAuthorsCategories(idToDelete);
        
        Set<Author> authors = book.getAuthors();
        List<Author> authorsList = new ArrayList<>(authors);
        Author author = authorsList.get(0);
        
        Category category = catDao.findById(2l);
        
        category.removeBook(book);
        
        authorDao.delete(author);
        bookDao.delete(book);
        logger.info("Deleting book and author done.\nNew set of books:");
        books = bookDao.findAllWAuthorsCategories();
        Two2Utils.listBooksWAuthorsCategories(books);
        
        ctx.close();
    }
}