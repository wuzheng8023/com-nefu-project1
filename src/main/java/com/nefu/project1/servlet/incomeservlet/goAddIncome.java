package com.nefu.project1.servlet.incomeservlet;

import com.nefu.project1.dao.DeptDao;
import com.nefu.project1.entity.Table_Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 来到添加收入页面
 */
@WebServlet("/goAddIncome")
public class goAddIncome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DeptDao deptDao = new DeptDao();
        List<Table_Dept> list = null;
        try {
            list = deptDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("listDept",list);
        req.getRequestDispatcher("/income_add.jsp").forward(req,resp);
    }
}
