package cn.gaily.test.engine;

import org.activiti.engine.RepositoryService;

import cn.gaily.utils.SpringContextService;

public class RepositoryServiceTest {

	public static void main(String[] args) {
		RepositoryService repository = (RepositoryService) SpringContextService.getService("repositoryService");
		
		String deploymenId = repository
				.createDeployment()
				.addClasspathResource("org/activiti/spring/test/hello.bpmn20.xml")
				.deploy()
				.getId();
		
		UserBean bean = (UserBean) SpringContextService.getService("userBean");
		bean.hello();
	}
}
