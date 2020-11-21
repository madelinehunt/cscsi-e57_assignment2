package cscie57.assignment2_2.dao;

import cscie57.assignment2_2.dao.BookDao;
import cscie57.assignment2_2.domain.Book;
import cscie57.assignment2_2.domain.Category;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SuppressWarnings("unchecked")
@Transactional
@Repository("bookDao")
public class BookDaoImpl implements BookDao {

    private static Log logger = LogFactory.getLog(BookDaoImpl.class);
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select b from Book b").list();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Book> findAllWAuthorsCategories() {
        return sessionFactory.getCurrentSession().getNamedQuery("Book.findBookWithAuthorCategories").list();
    }
    
    @Transactional(readOnly = true)
    public Book findByIdWAuthorsCategories(Long id) {
        return (Book) sessionFactory.getCurrentSession().
                getNamedQuery("Book.findBookByIdWithAuthorCategories").
                setParameter("id", id).uniqueResult();
    }
    
    @Transactional(readOnly = true)
    public List<Book> findBookCategoriesByAuthor(Long authorId){
        return sessionFactory.getCurrentSession().getNamedQuery("Book.findBookByAuthorId").setParameter("authorId", authorId).list();
    }
    
    public Book save(Book book) {
        sessionFactory.getCurrentSession().saveOrUpdate(book);
        logger.info("Book saved with id: " + book.getId());
        return book;
    }
    
    public void delete(Book book) {
        sessionFactory.getCurrentSession().delete(book);
        logger.info("Book deleted with id: " + book.getId());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
