package cscie57.assignment2_3.app;

import cscie57.assignment2_3.service.*;
import cscie57.assignment2_3.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class CreateBookWAuthor {
    private static Logger logger = LoggerFactory.getLogger(CreateBookWAuthor.class);

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();

        PublishingService publishingService = ctx.getBean(PublishingService.class);
        
        Author author = new Author();
        author.setFirstName("Paul");
        author.setLastName("Verlaine");
        author.setDescription("Paul-Marie Verlaine (30 March 1844 – 8 January 1896) was a French poet associated with the Symbolist movement and the Decadent movement. He is considered one of the greatest representatives of the fin de siècle in international and French poetry.");

        Book book = new Book();
        book.setISBN("978-0199554010");
        book.setTitle("Selected Poems");
        book.setPrice(7.98);
        book.addAuthor(author);
        
        Category category = publishingService.findCategoryById(4l);
        category.addBook(book);
        
        publishingService.saveAuthor(author);
        publishingService.saveBook(book);
        logger.info("Saving book done.\nNew set of books:");

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