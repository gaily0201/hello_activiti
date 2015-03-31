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
 *����bpmn����
 */
public class ActivitiAPITest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//������������
//		ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
//				.buildProcessEngine();
		
		//��ȡactiviti����
//		RepositoryService repositoryService = processEngine.getRepositoryService();
//		RuntimeService runtimeService = processEngine.getRuntimeService();
//		RepositoryService repositoryService = (RepositoryService) SpringContextService.getService("repositoryService");
		RuntimeService runtimeService = (RuntimeService) SpringContextService.getService("runtimeService");
		TaskService taskService = (TaskService) SpringContextService.getService("taskService");
		
		
		//�������̶���
//		Deployment deployment = repositoryService.createDeployment()
//				.addClasspathResource("diagrams/testProcess_1.bpmn20.xml")
//				.deploy();
		
		//��������ʵ��
		ProcessInstance processInstance =runtimeService.startProcessInstanceByKey("testProcess");
		String deployId = processInstance.getDeploymentId();
		System.out.println(deployId);
		
		//��ѯ����
		List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("kafeitu").list();
		for(Task t:tasks){
			System.out.print("id:"+t.getId());
			System.out.print("assignee:"+t.getAssignee());
			System.out.print("name:"+t.getName());
		}
	}

}
