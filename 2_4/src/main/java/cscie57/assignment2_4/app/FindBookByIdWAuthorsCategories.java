package cscie57.assignment2_4.app;

import cscie57.assignment2_4.service.*;
import cscie57.assignment2_4.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class FindBookByIdWAuthorsCategories {
    private static Logger logger = LoggerFactory.getLogger(FindBookByIdWAuthorsCategories.class);

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        logger.info("Book id=3 with authors and categories");
        
        Book book = publishingService.findById(3l);
        listBook(book);
        
        ctx.close();
    }
    
    public static void listBook(Book book) {
        logger.info(" ---- Listing books:");
        logger.info(book.toString());
        if (book.getCategory() != null){
            logger.info(book.getCategory().toString());
        }
        if (book.getAuthors() != null){
            book.getAuthors().forEach(a -> {
                logger.info(a.toString());
            });
        }
        logger.info("===\n");
   }
}