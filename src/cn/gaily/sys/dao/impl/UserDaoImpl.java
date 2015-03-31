package cn.gaily.sys.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import cn.gaily.sys.User;
import cn.gaily.sys.dao.UserDao;
import cn.gaily.utils.SpringContextService;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	Logger logger = Logger.getLogger(this.getClass());
	
	public User findUserByUserName(String userName) {
		org.springframework.jdbc.datasource.SimpleDriverDataSource datasource =
				(SimpleDriverDataSource) SpringContextService.getService("datasource");
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = datasource.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select id_,pwd_,email_ from act_id_user where id_='"+userName+"'");
			logger.debug("query user:"+userName);
			while(rs.next()){
				user = new User();
				user.setId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setEmail(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

}
