package com.jingoal.test.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jingoal.test.model.User;

@Service
public class UserManager {

    private static List<User> USER_LIST = new ArrayList<User>();

    static {
        User user = null;
        for (int i = 0; i < 10; i++) {
            user = new User();
            user.setId(i);
            user.setAge(i);
            user.setName("u" + i);
            USER_LIST.add(user);
        }
    }

    public void addUser(User user) {
        USER_LIST.add(user);
        System.out.println("add success! total :" + USER_LIST.size());
    }

    public User getById(int id) {
        User user = null;
        for (int i = 0; i < USER_LIST.size(); i++) {
            if (USER_LIST.get(i).getId() == id) {
                user = USER_LIST.get(i);
                break;
            }
        }
        return user;
    }
}
