package com.service;





import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;





public class Demo {
    public static void main(String[] args) {
        ApplicationContext a = new ClassPathXmlApplicationContext("client2.xml");
        JobService jobService=(JobService)a.getBean("jobService");
        System.out.println(jobService.show());
    }

}
