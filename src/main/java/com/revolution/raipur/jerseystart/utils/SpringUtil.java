package com.revolution.raipur.jerseystart.utils;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringUtil {
	private static SpringUtil instance = null;
	private static ApplicationContext context;
	private SpringUtil(){
		context = new ClassPathXmlApplicationContext("spring.xml");     
   }

   public static SpringUtil getInstance(){
        if(instance == null){
            instance  = new SpringUtil();
        }
        return instance;
   }
   
   public static ApplicationContext getApplicationContext() {
       return context;
  }

}
