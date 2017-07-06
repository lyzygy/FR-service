package cn.xiangyu.finereport.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author liuzg
 *
 */
public class DataAccess {
	private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
