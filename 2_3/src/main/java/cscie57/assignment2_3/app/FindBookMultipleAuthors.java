package cscie57.assignment2_3.app;

import cscie57.assignment2_3.service.*;
import cscie57.assignment2_3.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Collections; 
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Map;

public class FindBookMultipleAuthors {
    private static Logger logger = LoggerFactory.getLogger(FindBookMultipleAuthors.class);

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        
        List<Book> books = publishingService.findAllWAuthorsCategories();
        
        List<Author> authors = books.stream()
            .map(book -> book.getAuthors()
                .stream()
                .findFirst()
                .get()
            )
            .collect(Collectors.toList());
            
        Set<Author> multAuthorIds = authors.stream()
            .filter(auth -> Collections.frequency(authors, auth) > 1)
            .collect(Collectors.toSet());
        
        List<Book> multBooks = books.stream()
            .filter(
                book -> multAuthorIds.containsAll(
                    book.getAuthors()
                    )
            )
            .collect(Collectors.toList());
        
        List<Book> bookResults = multBooks.stream()
            .map(book -> publishingService.findByIdWAuthorsCategories(book.getId()))
            .collect(Collectors.toList());
        listBooks(bookResults);
        
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