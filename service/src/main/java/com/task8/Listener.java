package com.task8;



import com.service.JobService;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.setProperty("java.rmi.server.hostname", "106.14.4.157");
        System.out.println("芝麻开门");
        Node node= NodeFactory.newInstance().createNode("service.composite");
        node.start();
        System.out.println("开了。。。");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
