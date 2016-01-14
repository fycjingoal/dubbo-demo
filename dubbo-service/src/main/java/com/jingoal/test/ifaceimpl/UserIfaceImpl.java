package com.jingoal.test.ifaceimpl;

import java.lang.management.ManagementFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jingoal.test.common.CtrlVar;
import com.jingoal.test.exception.CommonException;
import com.jingoal.test.exception.DubboExceptValue;
import com.jingoal.test.iface.UserIface;
import com.jingoal.test.manager.UserManager;
import com.jingoal.test.model.User;
import com.jingoal.test.util.Util;

public class UserIfaceImpl implements UserIface {
    
    static Logger logger = LoggerFactory.getLogger(UserIfaceImpl.class);

    @Autowired
    private UserManager userManager;

    public void addUser(User user) throws CommonException {
        System.out.println("addUser");
        userManager.addUser(user);
    }

    public User getById(int id) throws CommonException {
        System.out.println("getById "+id);
        
        if(CtrlVar.simSlow > 0){
            logger.debug("sleep {}", CtrlVar.simSlow);
            try {
                Thread.sleep(CtrlVar.simSlow);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        User user = userManager.getById(id);
        if (user == null) {
            throw new CommonException(DubboExceptValue.USER_ALREADY_DELETE);
        }

//        user.setName("u" + user.getId() + " "+ Thread.currentThread().getId());
//        user.setName(String.format("u%d %s %d", user.getId(), ManagementFactory.getRuntimeMXBean().getName(), Thread.currentThread().getId()));
        user.setName(String.format("u%d %s %s %d",
                user.getId(),
                ManagementFactory.getRuntimeMXBean().getName(),
                Thread.currentThread(),
                Thread.currentThread().getId()
                ));
        return user;
    }

    /* (non-Javadoc)
     * @see com.jingoal.test.iface.UserIface#call(java.lang.String)
     */
    public String call(String arg) throws CommonException {
        String serviceVer = "server default";
        String id = Util.getSelfId(serviceVer);
        logger.debug(String.format("%s -> %s", arg, id));
        return id;
    }

}
