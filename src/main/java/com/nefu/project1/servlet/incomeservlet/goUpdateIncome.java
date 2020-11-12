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

@WebServlet("/goUpdateIncome")
public class goUpdateIncome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DeptDao deptDao = new DeptDao();
        List<Table_Dept> list = null;
        try {
            list = deptDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String income_id = req.getParameter("Income_id");
        req.setAttribute("listDept",list);
        req.setAttribute("Income_id",income_id);
         req.getRequestDispatcher("/income_update.jsp").forward(req,resp);
    }
}
