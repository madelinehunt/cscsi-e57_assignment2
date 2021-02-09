package cscie57.assignment2_4.app;

import cscie57.assignment2_4.service.*;
import cscie57.assignment2_4.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class FindAllBooksWoAuthorsCategories {
    private static Logger logger = LoggerFactory.getLogger(FindAllBooksWoAuthorsCategories.class);

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        
        List<Book> books = publishingService.findAll();
        listBooks(books);
        
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
        logger.info(" ---- Listing books:");
        books.forEach( b -> {
            logger.info("===");
            logger.info(b.toString());
            logger.info("===\n");
        });
   }
}
