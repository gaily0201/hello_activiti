package org.activiti.designer.test;
import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;

import cn.gaily.utils.SpringContextService;

public class DiagramTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		RepositoryService rservice = (RepositoryService) SpringContextService.getBean("repositoryService");
//		long cc = rservice.createDeploymentQuery().deploymentId("testProcess:2:7515")
//			.count();
//		System.out.println(cc);
//		if(cc<=0){
//			rservice.createDeployment()
//			.addClasspathResource("diagrams/testProcess_1.bpmn20.xml")
//			.deploy();
//		}
		
		RuntimeService runtimeService = (RuntimeService) SpringContextService.getBean("runtimeService");
		List<Execution> list =runtimeService.createExecutionQuery().list();
		for(Execution e: list){
			System.out.println(e.getActivityId());
			runtimeService.activateProcessInstanceById(e.getActivityId());
		}
	}

}
