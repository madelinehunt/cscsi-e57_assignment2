package cscie57.assignment2_3.app;

import cscie57.assignment2_3.service.*;
import cscie57.assignment2_3.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


import java.util.List;

public class FindAllBooksNativeQuery {
    private static Logger logger = LoggerFactory.getLogger(FindAllBooksNativeQuery.class);

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        logger.info("Searching with Native Query");

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        
        List<Book> books = publishingService.findAllByNativeQuery();
        listBooks(books);
        
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
        logger.info(" ---- Listing books:");
        books.forEach(s -> logger.info(s.toString()));
   }
}
