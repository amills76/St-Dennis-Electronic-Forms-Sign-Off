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

    /** Return a list of all users
     *
     * @return All users
     */
    public List<Login> getAllLogins() {
        List<Login> logins = new ArrayList<Login>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        logins = session.createCriteria(Login.class).list();
        return logins;
    }

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

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
    public int addLogin(Login login) {
        int loginId = 0;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(login);
            transaction.commit();
            loginId = login.getLoginId();
        }catch (HibernateException e) {
            if (transaction !=null) {
                transaction.rollback();
            }
            log.error(e);
        }finally {
            session.close();
        }
        return loginId;
    }

    /**
     * delete a login by id
     * @param loginId the login's id
     */
    public void deleteLogin(int loginId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Login login = (Login) session.get(Login.class, loginId);
            session.delete(login);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e);
        }finally {
            session.close();
        }

    }

    /**
     * Update the login
     * @param login
     */

    public void updateLogin(Login login) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(login);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e);
        }finally {
            session.close();
        }

    }
}

