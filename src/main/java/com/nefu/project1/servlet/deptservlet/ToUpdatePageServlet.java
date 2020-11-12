package com.nefu.project1.servlet.deptservlet;

import com.nefu.project1.dao.DeptDao;
import com.nefu.project1.entity.Table_Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zsy
 * @date 2020/11/10 0010 - 22:40
 */
@WebServlet("/toUpdatePageDept")
public class ToUpdatePageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            DeptDao deptDao = new DeptDao();
            String dept_id = request.getParameter("Dept_id");
            Table_Dept dept = deptDao.findOne(Integer.parseInt(dept_id));
            request.setAttribute("dept", dept);
            request.getRequestDispatcher("/dept_update.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.doPost(request, response);
    }
}
