package cscie57.assignment2_2.app;

import cscie57.assignment2_2.config.AppConfig;
import cscie57.assignment2_2.dao.*;
import cscie57.assignment2_2.domain.Book;
import cscie57.assignment2_2.utils.Two2Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class FindBookByIdWAuthorsCategories {
    private static Logger logger = LoggerFactory.getLogger(FindBookByIdWAuthorsCategories.class);

    public static void main(String... args) {
        GenericApplicationContext ctx = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        logger.info("Book id=4 with authors and categories");
        Book book = bookDao.findByIdWAuthorsCategories(4l);
        
        logger.info(book.toString());
        if (book.getCategory() != null){
            logger.info(book.getCategory().toString());
        }
        if (book.getAuthors() != null){
            book.getAuthors().forEach(a -> {
                logger.info(a.toString());
            });
        }
    }
}