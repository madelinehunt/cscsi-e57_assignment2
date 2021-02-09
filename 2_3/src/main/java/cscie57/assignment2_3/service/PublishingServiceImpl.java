package cscie57.assignment2_3.service;

import cscie57.assignment2_3.service.*;
import cscie57.assignment2_3.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    
    @Override
    public Book saveBook(Book book) {
        if (book.getId() == null) {
            logger.info("Inserting new book");
            em.persist(book);
        } else {
            em.merge(book);
            logger.info("Updating existing book");
        }

        logger.info("Book saved with id: " + book.getId());

        return book;
    }

    @Override
    public Author saveAuthor(Author author) {
        if (author.getId() == null) {
            logger.info("Inserting new author");
            em.persist(author);
        } else {
            em.merge(author);
            logger.info("Updating existing author");
        }

        logger.info("Author saved with id: " + author.getId());

        return author;
    }
    
    @Override
    public void deleteBook(Book book) {
        // using CriteriaBuilder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Book> criteriaDelete = cb.createCriteriaDelete(Book.class);
        Root<Book> root = criteriaDelete.from(Book.class);
        ArrayList<Long> ids = new ArrayList<Long>();
        ids.add(book.getId());
        criteriaDelete.where(root.get("id").in(ids));
        em.createQuery(criteriaDelete).executeUpdate();

        logger.info("Book with id: " + book.getId()  + " deleted successfully");
    }
    
    @Override
    public void deleteAuthor(Author author) {
        Author mergedContact = em.merge(author);
        em.remove(mergedContact);

        logger.info("Author with id: " + author.getId()  + " deleted successfully");
    }
    
    public Category findCategoryById(Long id) {
        TypedQuery<Category> query = em.createNamedQuery(Category.FIND_CATEGORY_BY_ID, Category.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    
    @Transactional(readOnly=true)
    @Override
    public List<Book> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_BOOKS_NATIVE_QUERY, "bookResult").getResultList();
    }   

}
