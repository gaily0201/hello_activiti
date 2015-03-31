package cn.gaily.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextService {

	
	private static ApplicationContext context;
	
	static{
		if(context==null){
			context = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		}
	}
	
	public static Object getService(String beanName){
		if(context==null||!context.containsBean(beanName)){
			throw new RuntimeException("not find service, service name is["+beanName+"]");
		}
		
		return context.getBean(beanName);
	}
}
