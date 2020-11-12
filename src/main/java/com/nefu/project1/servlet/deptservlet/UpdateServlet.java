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
 * @date 2020/11/10 0010 - 22:54
 */
@WebServlet("/updateDept")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        DeptDao deptDao = new DeptDao();
       String Dept_id = request.getParameter("Dept_id");
        String Dept_name = request.getParameter("Dept_name");
        String Dept_description = request.getParameter("Dept_description");
        String flag = request.getParameter("Dept_flag");
        Table_Dept dept = new Table_Dept();
        dept.setDept_id(Integer.parseInt(Dept_id));
        dept.setDept_name(Dept_name);
        dept.setDept_description(Dept_description);
        dept.setFlag(Integer.parseInt(flag));
        try {
            deptDao.update(dept);
            request.getRequestDispatcher("findAllDept").forward(request,response);
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
