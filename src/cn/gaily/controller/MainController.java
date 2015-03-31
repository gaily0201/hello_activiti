package cn.gaily.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.gaily.sys.service.UserService;

@Controller
public class MainController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="taskService")
	private TaskService taskService;
	
	@RequestMapping(value="/main/login")
	public ModelAndView main(){
		System.out.println("login");
		return new ModelAndView("/login");
	}
	
	@RequestMapping(value="/user/login")
	public ModelAndView login(HttpServletRequest req){
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");
		logger.debug("username:"+username+",password:"+password);
		
		String errmessage = "登入失败";
		
		if(userService.login(username,password)){
			//登陆成功 显示可发起的流程,显示代办任务
			List<Task> task = taskService.createTaskQuery().list();
			logger.debug(task.size());
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("username", username);
			map.put("task", task);
			return new ModelAndView("/main",map);
		}
		return new ModelAndView("error","message",errmessage);
	}

}
