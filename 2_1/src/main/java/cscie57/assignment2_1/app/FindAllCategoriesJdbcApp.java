package cscie57.assignment2_1.app;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cscie57.assignment2_1.utils.Two1Utils;
import cscie57.assignment2_1.dao.*;
import cscie57.assignment2_1.domain.*;

public class FindAllCategoriesJdbcApp {
    private static Logger logger = LoggerFactory.getLogger(
            FindAllCategoriesJdbcApp.class);
    
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
        CategoryDao categoryDao = ctx.getBean("categoryDao", Two1CategoryDao.class);
        List<Category> categories = categoryDao.findAll();
        Two1Utils.listCategories(categories);
        ctx.close();
    }
}
