import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.services.VillainService;

public class Driver {
	
	//This is how we'd do it without DI
	// private static VillainService villServ = new VillainService(new VillainDao...)
	
	//WE dont need to create our own instance when we have dependency injection
	private static VillainService villServ;
	
	public static void main(String[] args) {
		
		//Our IOC container Application COntext needs to reference the beans.xml file to configure our beans
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		//The application context creates an instance, the getBeans() method only refers to that single instance
		//This only to show that the bean is truly a singleton
		villServ = appContext.getBean("villServ", VillainService.class);
		//villServ = appContext.getBean("villServ", VillainService.class);
		//villServ = appContext.getBean("villServ", VillainService.class);
		
		System.out.println("Counter: " + VillainService.counter);
		
		System.out.println(villServ.getAllVills());
		
	}

}
