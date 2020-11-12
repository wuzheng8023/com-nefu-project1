package com.nefu.project1.servlet.incomeservlet;

import com.nefu.project1.dao.IncomeDao;
import com.nefu.project1.entity.Table_Income;
import com.nefu.project1.utils.DateFomat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addIncome")
public class addIncome extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IncomeDao incomeDao = new IncomeDao();
        Table_Income table_income = new Table_Income();
        table_income.setDept_id(Integer.parseInt(req.getParameter("dept_id")));
        table_income.setDaily_income(Integer.parseInt(req.getParameter("daily_income")));
        table_income.setBusiness_date(DateFomat.getNowDay());
        incomeDao.insertIncome(table_income);

        resp.sendRedirect("getAllIncome ");


    }
}
