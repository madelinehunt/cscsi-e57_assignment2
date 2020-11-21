package cscie57.assignment2_3.service;

import cscie57.assignment2_3.service.*;
import cscie57.assignment2_3.domain.*;
import cscie57.assignment2_3.domain.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Service("publishingService")
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class PublishingServiceImpl implements PublishingService {
    final static String ALL_BOOKS_NATIVE_QUERY =
        "select id, category_id, isbn, title, price from book";

    private static Logger logger = LoggerFactory.getLogger(PublishingServiceImpl.class);
    
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    @Override
    public List<Book> findAll() {
        return em.createNamedQuery(Book.FIND_ALL, Book.class).getResultList();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Book> findAllWAuthorsCategories() {
        return em.createNamedQuery(Book.FIND_BOOK_WITH_AUTHOR_CATEGORIES, Book.class).getResultList();
    }
    
    @Transactional(readOnly=true)
    @Override
    public Book findByIdWAuthorsCategories(Long id) {
        TypedQuery<Book> query = em.createNamedQuery(Book.FIND_BOOK_BY_ID_W_AUTHOR_CATEGORIES, Book.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    
    @Transactional(readOnly=true)
    @Override
    public List<Book> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_BOOKS_NATIVE_QUERY, "bookResult").getResultList();
    }   

}
