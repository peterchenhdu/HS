package hs.dao.base;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class MySessionFactory {

	private static SessionFactory sessionFactory;
	private MySessionFactory(){
		
	}
	
	public static synchronized SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			try {
			      Configuration configuration = new Configuration().configure();   
	                ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();  
	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	                return configuration.buildSessionFactory(serviceRegistry); 
			} catch (Exception e) {
				Logger.getLogger(MySessionFactory.class).error("getSessionFactory error.");
				e.printStackTrace();
				return null;
			}
		}else{
			return sessionFactory;
		}
	}
	
}
