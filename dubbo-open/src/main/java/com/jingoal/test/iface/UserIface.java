package com.jingoal.test.iface;

import com.jingoal.test.exception.CommonException;
import com.jingoal.test.model.User;

public interface UserIface {

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user) throws CommonException;

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    public User getById(int id) throws CommonException;
    
    public String call(String arg) throws CommonException;
}
