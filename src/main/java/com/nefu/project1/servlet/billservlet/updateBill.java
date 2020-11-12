package com.nefu.project1.servlet.billservlet;

import com.nefu.project1.dao.BillDao;
import com.nefu.project1.entity.Table_bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateBill")
public class updateBill extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BillDao billDao = new BillDao();
        Table_bill bill = null;
//        System.out.println("bill_id--" + req.getParameter("bill_id"));
        int id = Integer.parseInt(req.getParameter("bill_id"));
//        System.out.println(id);
        try {
            bill = billDao.findOne(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bill.setBill_paid_flag(1);

        try {
            billDao.update(bill);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String vname = req.getParameter("vname");
        System.out.println("myVname--" + vname);
        req.setAttribute("vname", vname);
        req.getRequestDispatcher("goVendorPay").forward(req, resp);
    }
}
