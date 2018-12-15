package com.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Random;


public class SwitchService {


    public static ApplicationContext switchBean() {

        ApplicationContext applicationContext;
        Random random = new Random();
        int i = random.nextInt(2);

        if (i == 1) {
            try {
                applicationContext = new ClassPathXmlApplicationContext("client1.xml");

            } catch (Exception e) {
                applicationContext = new ClassPathXmlApplicationContext("client2.xml");

            }

        } else {
            try {
                applicationContext = new ClassPathXmlApplicationContext("client2.xml");

            } catch (Exception e) {
                applicationContext = new ClassPathXmlApplicationContext("client1.xml");
            }
        }

        return applicationContext;

    }


}
