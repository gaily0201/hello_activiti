package cn.gaily.test.engine;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import cn.gaily.utils.SpringContextService;

public class SpringConfigurationTest{
	
	
	public static void main(String[] args) {
		
		ProcessEngine processEngine = (ProcessEngine) SpringContextService.getService("processEngine");
		
		processEngine.getFormService();
		processEngine.getHistoryService();
		processEngine.getManagementService();
		processEngine.getRepositoryService();
		processEngine.getRuntimeService();
		processEngine.getTaskService();
		processEngine.getProcessEngineConfiguration();
		
		IdentityService identityService = processEngine.getIdentityService();
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
