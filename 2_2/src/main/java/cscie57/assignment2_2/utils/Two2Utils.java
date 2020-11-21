package cscie57.assignment2_2.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import cscie57.assignment2_2.domain.Book;
import cscie57.assignment2_2.domain.Category;
import cscie57.assignment2_2.domain.Author;

public class Two2Utils {
    private static Logger logger = LoggerFactory.getLogger(
            Two2Utils.class);
    
    public static void listBooks(List<Book> books){
        books.forEach(book -> logger.info(book.toString()));
    }
    
    public static void listCategories(List<Category> categories){
        categories.forEach(category -> logger.info(category.toString()));
    }
    
    public static void listBooksWAuthorsCategories(List<Book> books){
        books.forEach( b -> {
            logger.info("===");
            logger.info(b.toString());
            if (b.getCategory() != null){
                logger.info(b.getCategory().toString());
            }
            if (b.getAuthors() != null){
                b.getAuthors().forEach(a -> {
                    logger.info(a.toString());
                });
            }
            logger.info("===\n");
        });
    }
}
