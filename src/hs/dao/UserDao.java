package hs.dao;

import hs.dao.base.MySessionFactory;
import hs.model.User;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;


public class UserDao {
	
    public void add(User user){
    	Session session = MySessionFactory.getSessionFactory().openSession();
    	session.beginTransaction();
    	
    	session.save(user);
         
	    session.getTransaction().commit();
	    
	    session.close();
    }
    
    @SuppressWarnings("unchecked")
	public List<User> queryAllUser(){
        
    	List<User> users = new ArrayList<User>();
    	Session session = null;
    	try{
	    	session = MySessionFactory.getSessionFactory().openSession();
	    	session.beginTransaction();
	       
	        users = session.createQuery( "from User" ).setCacheable(true).list();
	       
	        session.getTransaction().commit();
	        
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		session.close();
    	}
        
        return users;
    }
}
