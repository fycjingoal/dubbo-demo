package com.jingoal.test.iface;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jingoal.test.model.User;
import com.jingoal.test.util.Util;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:root-context.xml")
public class UserIfaceTest {
    
    static Logger logger = LoggerFactory.getLogger(UserIfaceTest.class);

    @Autowired
    private UserIface userIface;

//    @Test
    public void testAddUser() {
System.out.println(1);
        User user = new User();
        user.setAge(11);
        user.setId(11);
        user.setName("u11");
        userIface.addUser(user);
System.out.println(2);
    }

    @Test
    public void getUserById(){
        int total =
//                3600
                3
                ;
        for (int i = 0; i < total; i++) {
//            System.out.println(3);
            User u = userIface.getById(3);
//            Assert.assertEquals("u3", u.getName());
            Assert.assertEquals(3, u.getId());
            System.out.println(u.getName());
//            System.out.println(4);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
//    @Test
    public void testCallOnce(){
        String id = Util.getSelfId();
        String sid = userIface.call(id);
        logger.info(String.format("%s -> %s", sid, id));
        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCall(){
        int total =
                3600
                ;
        String id = Util.getSelfId();
        for(int i=0;i<total;i++){
            String sid = userIface.call(id);
            logger.info(String.format("%s -> %s", sid, id));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
