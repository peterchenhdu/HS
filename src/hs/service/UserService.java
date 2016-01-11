package hs.service;

import hs.dao.UserDao;
import hs.model.User;

import java.util.List;



public class UserService {
	private UserDao userDao = new UserDao();
	public List<User> queryAllUser(){
		return userDao.queryAllUser();
		
	}
	public void add(User user){
		userDao.add(user);
	}
}
