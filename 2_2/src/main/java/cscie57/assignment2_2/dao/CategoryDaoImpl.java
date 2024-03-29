package cscie57.assignment2_2.dao;

import cscie57.assignment2_2.dao.CategoryDao;
import cscie57.assignment2_2.domain.Category;
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
        // return (Category) sessionFactory.getCurrentSession().createQuery("select distinct c from Category c where c.id = " + String.valueOf(id)).uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select c from Category c").list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public Category save(Category category) {
        sessionFactory.getCurrentSession().saveOrUpdate(category);
        logger.info("Category saved with id: " + category.getId());
        return category;
    }
    
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
