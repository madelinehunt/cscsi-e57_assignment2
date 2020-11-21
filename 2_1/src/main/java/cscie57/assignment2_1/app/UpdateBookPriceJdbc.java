package cscie57.assignment2_1.app;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cscie57.assignment2_1.utils.Two1Utils;
import cscie57.assignment2_1.dao.*;
import cscie57.assignment2_1.domain.*;

public class UpdateBookPriceJdbc {
    private static Logger logger = LoggerFactory.getLogger(
            UpdateBookPriceJdbc.class);
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
        BookDao bookDao = ctx.getBean("bookDao", Two1BookDao.class);
        
        logger.info("Updating book price for book:");
        Book book = bookDao.findById(6l);
        logger.info(book.toString());
        
        bookDao.updatePrice(6l, 39.99);
        
        logger.info("\nListing all books:");
        List<Book> allBooks = bookDao.findAll();
        Two1Utils.listBooks(allBooks);
        ctx.close();
    }
}
