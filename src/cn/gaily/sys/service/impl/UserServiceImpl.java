package cn.gaily.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.gaily.sys.User;
import cn.gaily.sys.dao.UserDao;
import cn.gaily.sys.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	public boolean login(String userName, String password) {
		User user = userDao.findUserByUserName(userName);
		if(user==null){
			return false;
		}
		return userName.equalsIgnoreCase(user.getId())&&password.equals(user.getPassword());
	}
}
