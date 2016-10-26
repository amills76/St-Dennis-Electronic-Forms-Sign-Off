package edu.matc.persistence;

import edu.matc.entity.Login;
import edu.matc.entity.Parent;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Created by paulawaite on 2/2/16.
 */
public class parentDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * retrieve a parent given their user_id
     *
     * @param user_id the user_id
     * @return parent
     */
    public Parent getParent(String user_id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Parent parent = new Parent();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Parent.class);
            criteria.add(Restrictions.eq("user_id", user_id));
            parent = (Parent) criteria.uniqueResult();
        }catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e);
        }
        return parent;
    }


}


