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
	 * 1、查询当前日期的数据
	 * 	    1.1  有，拿到sequence+1，更新该条数据
	 *      1.2  否，补一条当天的数据，并返回初始化的sequence
	 */
	
	
}
