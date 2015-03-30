package cn.gaily.test.engine;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;

/**
 * <p>Title: CreateEngine</P>
 * <p>Description: 创建引擎</p>
 * @author xiaoh
 * @version 1.0
 * @since 2015-3-30
 */
public class CreateEngine {

	
	public static void main(String[] args) {
		
		ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
				.setJdbcDriver("com.mysql.jdbc.Driver")
				.setJdbcUrl("jdbc:mysql://localhost:3306/hello_activiti?characterEncoding=UTF8")
				.setJdbcUsername("root")
				.setJdbcPassword("123456")
				.setJobExecutorActivate(true)
				.setDatabaseSchemaUpdate(ProcessEngineConfigurationImpl.DB_SCHEMA_UPDATE_CREATE) //会在引擎中拿到脚本执行数据库DDL语句
																							     //如DbSchemaCreate
				.buildProcessEngine();
		
		
		
		IdentityService identityService =  processEngine.getIdentityService();
		List<User> users = identityService.createUserQuery().list();
		for(User user:users){
			System.out.print("username=:"+user.getFirstName());
			System.out.print("email=:"+user.getEmail());
			System.out.print("id=:"+user.getId());
			System.out.print("lasttime=:"+user.getLastName());
			System.out.println();
		}
	}
	
}
