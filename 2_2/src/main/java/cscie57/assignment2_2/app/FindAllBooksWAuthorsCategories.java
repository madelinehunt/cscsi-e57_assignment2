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

public class FindAllBooksWAuthorsCategories {
    private static Logger logger = LoggerFactory.getLogger(FindAllBooksWAuthorsCategories.class);

    public static void main(String... args) {
        GenericApplicationContext ctx = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        logger.info("Listing books with authors and categories");
        List<Book> books = bookDao.findAllWAuthorsCategories();
        Two2Utils.listBooksWAuthorsCategories(books);
        
        ctx.close();
    }
}