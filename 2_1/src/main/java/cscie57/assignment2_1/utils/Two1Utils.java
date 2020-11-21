package cscie57.assignment2_1.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import cscie57.assignment2_1.domain.Book;
import cscie57.assignment2_1.domain.Category;
import cscie57.assignment2_1.dao.CategoryDao;
import cscie57.assignment2_1.dao.Two1CategoryDao;

public class Two1Utils {
    private static Logger logger = LoggerFactory.getLogger(
            Two1Utils.class);
            
    public boolean checkCategoryExists(Long catId){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();
        
        CategoryDao categoryDao = ctx.getBean("categoryDao", Two1CategoryDao.class);
        List<Category> categories = categoryDao.findAll();
        List<Long> allCategoryIds = categories.stream()
            .map(cat -> cat.getId())
            .collect(Collectors.toList());
        System.out.println(allCategoryIds.toString());
        // 
        // if(allCategoryIds.includes(catId)) {
        //     return true;
        // } else {
        //     return false;
        // };
        return true;
    }
    
    public static void listBooks(List<Book> books){
        books.forEach(book -> logger.info(book.toString()));
    }
    
    public static void listCategories(List<Category> categories){
        categories.forEach(category -> logger.info(category.toString()));
    }
}