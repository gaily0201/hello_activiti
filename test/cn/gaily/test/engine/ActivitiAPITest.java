package cn.gaily.test.engine;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import cn.gaily.utils.SpringContextService;

/**
 *部署bpmn测试
 */
public class ActivitiAPITest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//创建流程引擎
//		ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
//				.buildProcessEngine();
		
		//获取activiti服务
//		RepositoryService repositoryService = processEngine.getRepositoryService();
//		RuntimeService runtimeService = processEngine.getRuntimeService();
//		RepositoryService repositoryService = (RepositoryService) SpringContextService.getService("repositoryService");
		RuntimeService runtimeService = (RuntimeService) SpringContextService.getService("runtimeService");
		TaskService taskService = (TaskService) SpringContextService.getService("taskService");
		
		
		//部署流程定义
//		Deployment deployment = repositoryService.createDeployment()
//				.addClasspathResource("diagrams/testProcess_1.bpmn20.xml")
//				.deploy();
		
		//启动流程实例
		ProcessInstance processInstance =runtimeService.startProcessInstanceByKey("testProcess");
		String deployId = processInstance.getDeploymentId();
		System.out.println(deployId);
		
		//查询任务
		List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("kafeitu").list();
		for(Task t:tasks){
			System.out.print("id:"+t.getId());
			System.out.print("assignee:"+t.getAssignee());
			System.out.print("name:"+t.getName());
		}
	}

}
