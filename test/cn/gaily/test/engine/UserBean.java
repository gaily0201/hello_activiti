package cn.gaily.test.engine;

import org.activiti.engine.RuntimeService;
import org.springframework.transaction.annotation.Transactional;

public class UserBean {

	private RuntimeService runtimeService;
	
	@Transactional
	public void hello(){
		runtimeService.startProcessInstanceById("helloProcess");
	}
	
	
	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}
	
	
}
