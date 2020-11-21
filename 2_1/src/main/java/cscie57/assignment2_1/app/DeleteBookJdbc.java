package cscie57.assignment2_1.app;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cscie57.assignment2_1.utils.Two1Utils;
import cscie57.assignment2_1.dao.*;
import cscie57.assignment2_1.domain.*;

public class DeleteBookJdbc {
    private static Logger logger = LoggerFactory.getLogger(
            DeleteBookJdbc.class);
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
        BookDao bookDao = ctx.getBean("bookDao", Two1BookDao.class);
        
        bookDao.delete(6l);
        logger.info("\nListing all books:");
        
        List<Book> allBooks = bookDao.findAll();
        Two1Utils.listBooks(allBooks);
        ctx.close();
    }
}
