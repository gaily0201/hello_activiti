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
	
	/**
	 *   id || time(yyyy-mm-dd)|| sequence
	 * 
	 * 1����ѯ��ǰ���ڵ�����
	 * 	    1.1  �У��õ�sequence+1�����¸�������
	 *      1.2  �񣬲�һ����������ݣ������س�ʼ����sequence
	 */
	
	
}
