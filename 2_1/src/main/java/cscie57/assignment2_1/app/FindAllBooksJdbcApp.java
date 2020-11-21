package cscie57.assignment2_1.app;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cscie57.assignment2_1.utils.Two1Utils;
import cscie57.assignment2_1.dao.*;
import cscie57.assignment2_1.domain.*;

public class FindAllBooksJdbcApp {
    private static Logger logger = LoggerFactory.getLogger(
            FindAllBooksJdbcApp.class);
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
        BookDao bookDao = ctx.getBean("bookDao", Two1BookDao.class);
        List<Book> books = bookDao.findAll();
        Two1Utils.listBooks(books);
        ctx.close();
    }
}
