package com.nefu.project1.servlet.vendorservlet;

import com.nefu.project1.dao.BillDao;
import com.nefu.project1.dao.VendorDao;
import com.nefu.project1.entity.Table_bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/goVendorPay")
public class goVendorPay extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VendorDao vendorDao = new VendorDao();
        BillDao billDao = new BillDao();

        List<Table_bill> billList = null;
        try {
            billList = billDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String vname = req.getParameter("vendorname");

        int vendor_id = vendorDao.getVendorByName(vname).getVendor_id();

        List<Table_bill> list = new LinkedList<>();

        //0代表未支付，1代表支付
        for (Table_bill bill : billList) {
            if (bill.getVendor_id() == vendor_id && bill.getBill_paid_flag() == 0) {
                list.add(bill);
            }
        }

        req.setAttribute("vname", vname);
        req.setAttribute("billlist", list);
        req.getRequestDispatcher("/vendor_pay.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VendorDao vendorDao = new VendorDao();
        BillDao billDao = new BillDao();
        List<Table_bill> billList = null;
        try {
            billList = billDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String vname = req.getParameter("vname");

        int vendor_id = vendorDao.getVendorByName(vname).getVendor_id();

        List<Table_bill> list = new LinkedList<>();

        //0代表未支付，1代表支付
        for (Table_bill bill : billList) {
            if (bill.getVendor_id() == vendor_id && bill.getBill_paid_flag() == 0) {
                list.add(bill);
            }
        }

        req.setAttribute("vname", vname);
        req.setAttribute("billlist", list);
        req.getRequestDispatcher("/vendor_pay.jsp").forward(req, resp);
    }
}
