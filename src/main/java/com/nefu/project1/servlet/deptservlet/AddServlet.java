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
 * @date 2020/11/10 0010 - 23:07
 */
@WebServlet("/addDept")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        DeptDao deptDao = new DeptDao();
        String dept_name = request.getParameter("Dept_name");
        String dept_description = request.getParameter("Dept_description");
        Table_Dept dept = new Table_Dept();
        dept.setDept_name(dept_name);
        dept.setDept_description(dept_description);
        dept.setFlag(1);
        try {
            deptDao.insert(dept);
            response.sendRedirect("findAllDept");
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
