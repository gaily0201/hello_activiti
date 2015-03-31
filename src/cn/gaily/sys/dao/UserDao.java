package cn.gaily.sys.dao;


import cn.gaily.sys.User;

public interface UserDao {

	User findUserByUserName(String userName);

}
