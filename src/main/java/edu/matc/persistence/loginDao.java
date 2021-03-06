package edu.matc.persistence;

import edu.matc.entity.Login;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 2/2/16.
 */
public class loginDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * retrieve a user given their id
     *
     * @param loginId the login ID
     * @return login
     */
    public Login getLogin(int loginId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Login login = new Login();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Login.class);
            criteria.add(Restrictions.eq("loginId", loginId));
            login = (Login) criteria.uniqueResult();
        }catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e);
        }
        return login;
    }
}

