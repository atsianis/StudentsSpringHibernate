package com.mycompany.studentsspringhibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	// auto einai to antistoixo EntityManagerFactory
        // ftiaxnei sessions ta opoia mapparontai me ta sessions pou ftiaxnei to jvm kai sta web apps
        // mesa edw tha paixtei kai to security
	private static final SessionFactory sessionFactory;
	
	static{
		try{
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

		}catch (Throwable ex) {
			System.err.println("Session Factory could not be created." + ex);
			throw new ExceptionInInitializerError(ex);
		}	
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
