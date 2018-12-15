package com.service;




public class MainService {

    public static void main(String[] args) {

        Node node= NodeFactory.newInstance().createNode("service.composite");
           node.start();
        System.out.println("芝麻开门");
    }
}
