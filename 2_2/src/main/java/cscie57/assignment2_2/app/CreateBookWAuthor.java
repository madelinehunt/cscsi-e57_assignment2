package cscie57.assignment2_2.app;

import cscie57.assignment2_2.config.AppConfig;
import cscie57.assignment2_2.dao.*;
import cscie57.assignment2_2.domain.*;
import cscie57.assignment2_2.utils.Two2Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class CreateBookWAuthor {
    private static Logger logger = LoggerFactory.getLogger(CreateBookWAuthor.class);

    public static void main(String... args) {
        GenericApplicationContext ctx = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        CategoryDao catDao = ctx.getBean(CategoryDao.class);
        AuthorDao authorDao = ctx.getBean(AuthorDao.class);
        
        Author author = new Author();
        author.setFirstName("Eugene");
        author.setLastName("Ionesco");
        author.setDescription("Eugène Ionesco (26 November 1909 – 28 March 1994) was a Romanian-French playwright who wrote mostly in French, and one of the foremost figures of the French Avant-garde theatre. Beyond ridiculing the most banal situations, Ionesco's plays depict the solitude and insignificance of human existence in a tangible way.");
        
        Book book = new Book();
        book.setISBN("978-2701151410");
        book.setTitle("La Cantatrice Chauve");
        book.setPrice(7.98);
        book.addAuthor(author);
        
        Category category = catDao.findById(2l);
        category.addBook(book);
        
        // bookDao.save(book);
        catDao.save(category);
        logger.info("Saving book done.\nNew set of books:");
        List<Book> books = bookDao.findAllWAuthorsCategories();
        Two2Utils.listBooksWAuthorsCategories(books);
        
        ctx.close();
    }
}