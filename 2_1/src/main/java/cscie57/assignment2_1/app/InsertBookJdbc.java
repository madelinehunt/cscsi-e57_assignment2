package cscie57.assignment2_1.app;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cscie57.assignment2_1.utils.Two1Utils;
import cscie57.assignment2_1.dao.*;
import cscie57.assignment2_1.domain.*;

public class InsertBookJdbc {
    private static Logger logger = LoggerFactory.getLogger(
            InsertBookJdbc.class);
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
        BookDao bookDao = ctx.getBean("bookDao", Two1BookDao.class);
        Book newBook = new Book();
        newBook.setCategoryId(4l);
        newBook.setISBN("978-0974635330");
        newBook.setTitle("Leadbelly");
        newBook.setPrice(12.39);
        
        logger.info("Creating new book:");
        logger.info(newBook.toString());
        bookDao.insert(newBook);
        logger.info("\nListing all books:");
        
        List<Book> allBooks = bookDao.findAll();
        Two1Utils.listBooks(allBooks);
        ctx.close();
    }
}
