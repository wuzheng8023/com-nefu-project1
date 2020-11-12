package com.nefu.project1.servlet.userservlet;

import com.nefu.project1.dao.UserDao;
import com.nefu.project1.entity.ResultInfo;
import com.nefu.project1.entity.Table_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zsy
 * @date 2020/11/12 0012 - 9:04
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        UserDao userDao = new UserDao();
        Table_User user = userDao.findUserByNameAndPassword(userName, pwd);
        System.out.println(user);
        ResultInfo info = new ResultInfo();
        if(user == null) {
           request.getRequestDispatcher("/error.html").forward(request,response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            info.setFlag(true);
              request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        // 响应数据
/*       ObjectMapper mapper = new ObjectMapper();
       response.setContentType("application/json;charset=utf-8");
       mapper.writeValue(response.getOutputStream(),info);*/

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.doPost(request, response);
    }
}
