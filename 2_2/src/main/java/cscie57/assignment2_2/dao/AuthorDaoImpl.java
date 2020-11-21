package cscie57.assignment2_2.dao;

import cscie57.assignment2_2.dao.CategoryDao;
import cscie57.assignment2_2.domain.Author;
import cscie57.assignment2_2.domain.Category;
import cscie57.assignment2_2.domain.Author;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Repository("authorDao")
public class AuthorDaoImpl implements AuthorDao {

    private static final Log logger = LogFactory.getLog(AuthorDaoImpl.class);
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Transactional(readOnly = true)
    public Author findById(Long id) {
        return (Author) sessionFactory.getCurrentSession().
                getNamedQuery("Author.findAuthorById").
                setParameter("id", id).uniqueResult();
    }
    
    public Author save(Author author) {
        sessionFactory.getCurrentSession().saveOrUpdate(author);
        logger.info("Author saved with id: " + author.getId());
        return author;
    }
    
    public void delete(Author author) {
        sessionFactory.getCurrentSession().delete(author);
        logger.info("Author deleted with id: " + author.getId());
    }
    
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
