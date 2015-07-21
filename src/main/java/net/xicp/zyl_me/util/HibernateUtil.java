package net.xicp.zyl_me.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static Session session;
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}

    public static Session getSession()
    {
    	Session session = threadLocal.get();
    	if(session == null || !session.isOpen())
    	{
    		session = sessionFactory.getCurrentSession();
    		threadLocal.set(session);
    	}
		return session;
    }

}