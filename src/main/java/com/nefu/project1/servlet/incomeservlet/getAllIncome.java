package com.nefu.project1.servlet.incomeservlet;

import com.nefu.project1.VO.AllIncome;
import com.nefu.project1.dao.DeptDao;
import com.nefu.project1.dao.IncomeDao;
import com.nefu.project1.entity.Table_Dept;
import com.nefu.project1.entity.Table_Income;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


@WebServlet("/getAllIncome")
public class getAllIncome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IncomeDao incomeDao = new IncomeDao();
        DeptDao deptDao = new DeptDao();

        List<Table_Income> table_incomeList = incomeDao.getAllIncome();
        List<AllIncome> list = new LinkedList<>();
        for (Table_Income income : table_incomeList) {

            if (income.getFlag() != 0) {
                Table_Dept table_dept = new Table_Dept();
                AllIncome allIncome = new AllIncome();

                try {
                    table_dept = deptDao.findOne(income.getDept_id());
                    String deptName = table_dept.getDept_name();
                    allIncome.setDeptName(deptName);
                    allIncome.setIncome(income);
                    list.add(allIncome);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }


        req.setAttribute("incomeList", list);

        RequestDispatcher rd = req.getRequestDispatcher("/income_index.jsp");//这个路径默认是去webapp下面去寻找的
        rd.forward(req, resp);
    }
}
