package cscie57.assignment2_4.app;

import cscie57.assignment2_4.service.*;
import cscie57.assignment2_4.domain.*;

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
        author.setFirstName("Italo");
        author.setLastName("Calvino");
        author.setDescription("Italo Calvino (15 October 1923 – 19 September 1985) was an Italian journalist and writer of short stories and novels. His best known works include the Our Ancestors trilogy (1952–1959), the Cosmicomics collection of short stories (1965), and the novels Invisible Cities (1972) and If on a winter's night a traveler (1979). Admired in Britain, Australia and the United States, he was the most translated contemporary Italian writer at the time of his death.[5]");

        Book book = new Book();
        book.setISBN("978-0156439619");
        book.setTitle("If on a winter's night a traveler");
        book.setPrice(12.69);
        book.addAuthor(author);
        
        Category category = publishingService.findCategoryById(2l);
        category.addBook(book);
        
        publishingService.saveAuthor(author);
        publishingService.saveBook(book);
        logger.info("Saving book done.\nNew set of books:");

        List<Book> books = publishingService.findAll();
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