package com.jingoal.test.business;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * dubbo统一入口
 * @author zhengzhq
 * 
 */
public class ServerMain {

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "classpath:root-context.xml" });
        context.start();
        System.out.println("Start Success!!!");
        while (true) {
            Thread.sleep(10000);
//            System.out.println(new Date()+" isRunning:" + context.isRunning());
        }
    }
}