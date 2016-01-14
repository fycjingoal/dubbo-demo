package com.jingoal.test.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jingoal.test.iface.UserIface;
import com.jingoal.test.model.User;
import com.jingoal.test.util.Util;

/**
 * dubbo统一入口
 * @author zhengzhq
 * 
 */
public class ClientMain {
    
    static Logger logger = LoggerFactory.getLogger(ClientMain.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "classpath:root-context.xml" });
        
        UserIface userIface = (UserIface) context.getBean("userIface");
        
        test1(userIface);
        
        test2(userIface);
        
        context.close();
    }

    /**
     * @param userIface
     */
    private static void test2(UserIface userIface) {
        int total =
                3600
                ;
        String clientVer = "client default";
        String id = Util.getSelfId(clientVer);
        for(int i=0;i<total;i++){
            String sid = userIface.call(id);
            logger.info(String.format(" %s -> %s", id, sid));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test1(UserIface userIface) throws InterruptedException {
        for(int i=0;i<3;i++){
            User u = userIface.getById(3);
            System.out.println(u);
            Thread.sleep(1000);
        }
    }
}
