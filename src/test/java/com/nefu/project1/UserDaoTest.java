package com.nefu.project1;

import com.nefu.project1.dao.UserDao;
import com.nefu.project1.entity.Table_User;
import org.junit.Test;

public class UserDaoTest {
  private UserDao userDao = new UserDao();

    @Test
    public void test_getAllUser() {
        for (Table_User user : userDao.getAllUser()) {
            System.out.println(user);
        }

    }

    @Test
    public void test_insertUser() {

        Table_User table_user = new Table_User();
        table_user.setUserName("admin");
        table_user.setPwd("123456");
        userDao.insertUser(table_user);
    }

    @Test
    public void test_updateUser() {
        Table_User table_user = userDao.getAllUser().get(0);
//        userDao.getAllUser().get(0).setUserName("root");
        table_user.setUserName("root");
        System.out.println(table_user);

        System.out.println(userDao.updateUser(table_user));

    }

    @Test
    public void test_getUserByid() {
        System.out.println(userDao.getUserByID(2));

    }

}
