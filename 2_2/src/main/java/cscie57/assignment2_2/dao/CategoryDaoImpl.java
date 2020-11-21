package cscie57.assignment2_2.dao;

import cscie57.assignment2_2.dao.CategoryDao;
import cscie57.assignment2_2.domain.Book;
import cscie57.assignment2_2.domain.Category;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

    private static final Log logger = LogFactory.getLog(CategoryDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return (Category) sessionFactory.getCurrentSession().
                getNamedQuery("Category.findCategoryById").
                setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select c from Category c").list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
