package cscie57.assignment2_1.app;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cscie57.assignment2_1.utils.Two1Utils;
import cscie57.assignment2_1.dao.*;
import cscie57.assignment2_1.domain.*;

public class FindBooksByCategoryName {
    private static Logger logger = LoggerFactory.getLogger(
            FindBooksByCategoryName.class);
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
        BookDao bookDao = ctx.getBean("bookDao", Two1BookDao.class);
        List<Book> books = bookDao.findByCategoryName("Literary Fiction");
        logger.info("Find all books by category: Literary Fiction");
        Two1Utils.listBooks(books);
        ctx.close();
    }
}
