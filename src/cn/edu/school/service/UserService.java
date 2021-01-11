package cn.edu.uibe.service;

import cn.edu.uibe.dao.UserDAO;
import cn.edu.uibe.domain.User;

public class UserService {
	
   public User login(User user){
	   if(user==null) return null;
	   if(user.getPassword()==null||user.getUserName()==null){
		   return null;
	   }
	   UserDAO userDAO = new UserDAO();
	   User userDB = userDAO.findUserByUserName(user.getUserName());
	   if(userDB==null){
		   return null;
	   }
	   if(userDB.getPassword().equals(user.getPassword())){
		   return userDB; //明文密码相等认证成功
	   }
	   return null;
	}
}
