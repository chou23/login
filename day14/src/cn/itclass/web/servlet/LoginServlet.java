package cn.itclass.web.servlet;

import cn.itclass.dao.UserDao;
import cn.itclass.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        //调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        //判断user
        if(user == null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            //登录成功 储存数据
            req.setAttribute("user", user);
            //转发
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
