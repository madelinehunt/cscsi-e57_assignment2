package cscie57.assignment2_3.app;

import cscie57.assignment2_3.service.*;
import cscie57.assignment2_3.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


import java.util.List;

public class FindAllBooksWAuthorsCategories {
    private static Logger logger = LoggerFactory.getLogger(FindAllBooksWAuthorsCategories.class);

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        logger.info("Book id=2 with authors and categories");
        
        List<Book> books = publishingService.findAllWAuthorsCategories();
        listBooks(books);
        
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
        logger.info(" ---- Listing books:");
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
