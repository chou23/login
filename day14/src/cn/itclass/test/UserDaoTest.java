package cn.itclass.test;

import cn.itclass.dao.UserDao;
import cn.itclass.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("数据库设定的名");
        loginuser.setPassword("数据库设定的mima");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
