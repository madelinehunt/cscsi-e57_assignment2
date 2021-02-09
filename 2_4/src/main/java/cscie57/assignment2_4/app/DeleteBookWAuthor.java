package cscie57.assignment2_4.app;

import cscie57.assignment2_4.service.*;
import cscie57.assignment2_4.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Collections; 
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class DeleteBookWAuthor {
    private static Logger logger = LoggerFactory.getLogger(DeleteBookWAuthor.class);

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        
        // find highest id of books, to guard against any DB changes
        List<Book> books = publishingService.findAll();
        List<Long> ids = books.stream()
            .map(book -> book.getId())
            .collect(Collectors.toList());
        Long idToDelete = Collections.max(ids);
        
        Book book = publishingService.findById(idToDelete);
        
        Set<Author> authors = book.getAuthors();
        List<Author> authorsList = new ArrayList<>(authors);
        Author author = authorsList.get(0);
        
        publishingService.deleteBook(book);
        publishingService.deleteAuthor(author);
        
        logger.info("Deleting book and author done.\nNew set of books:");
        books = publishingService.findAll();
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