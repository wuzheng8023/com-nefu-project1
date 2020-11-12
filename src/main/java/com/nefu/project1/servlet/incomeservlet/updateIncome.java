package com.nefu.project1.servlet.incomeservlet;

import com.nefu.project1.dao.IncomeDao;
import com.nefu.project1.entity.Table_Income;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updateIncome")
public class updateIncome extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IncomeDao incomeDao = new IncomeDao();

        Table_Income table_income = incomeDao.getIncomeByID(Integer.parseInt(req.getParameter("Income_id")));
        table_income.setDept_id(Integer.parseInt(req.getParameter("dept_id")));
        table_income.setDaily_income(Integer.parseInt(req.getParameter("daily_income")));
//        table_income.setBusiness_date(Date.valueOf(req.getParameter("business_date")));
//        table_income.setFlag(Integer.parseInt(req.getParameter("flag")));
        table_income.setIncome_id(table_income.getIncome_id());
        incomeDao.updateIncome(table_income);

        resp.sendRedirect("getAllIncome ");
    }
}
