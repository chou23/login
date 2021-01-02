package cn.itclass.dao;

import cn.itclass.domain.User;
import cn.itclass.util.JDBCUtils;
import org.springframework.jdbc.core.BeanProperyRowMapper;
import org.springframework.jdbc.core.jdbcTemplate;

/*
* 操作数据库中的user表的类 增删改查*/
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /*
    * login method
    * @param loginUser uesrname password
    * return user*/
    public User login(User loginUser){
        try{


       //编写sql
        String sql = "select * from user where username = ? and password = ?";
        //调用query方法
        User user = template.queryForObject(sql, new BeanProperyRowMapper<User>(User.class),
                loginUser.getUsername(), loginUser.getPassword());

        return user;
        }catch (DataAccessException e){
            e.printStarckTrace();
            return null;
        }

    }
}
