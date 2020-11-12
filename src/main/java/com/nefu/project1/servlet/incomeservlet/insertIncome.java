package com.nefu.project1.servlet.incomeservlet;

import com.nefu.project1.dao.IncomeDao;
import com.nefu.project1.entity.Table_Income;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/insertIncome")
public class insertIncome extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IncomeDao incomeDao = new IncomeDao();
        Table_Income table_income = new Table_Income();
        table_income.setDept_id(Integer.parseInt(req.getParameter("Dept_id")));
        table_income.setDaily_income(Integer.parseInt(req.getParameter("Daily_income")));
        table_income.setBusiness_date(Date.valueOf(req.getParameter("Business_date")));
        table_income.setFlag(Integer.parseInt(req.getParameter("flag")));
        table_income.setIncome_id(Integer.parseInt(req.getParameter("Income_id")));
        incomeDao.insertIncome(table_income);
        List<Table_Income> table_incomeList =incomeDao.getAllIncome();

        List<Table_Income> list = new LinkedList<>();

        for (Table_Income table_income1 : table_incomeList) {
            if (table_income.getFlag() != 0) {
                list.add(table_income);
            }
        }
//        req.setAttribute("incomeList", table_incomeList);
        req.setAttribute("incomeList", table_incomeList);

//        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/index.jsp");//这个路径默认是去webapp下面去寻找的
//        rd.forward(req,resp);

    }
}
