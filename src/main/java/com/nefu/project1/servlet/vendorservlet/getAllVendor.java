package com.nefu.project1.servlet.vendorservlet;

import com.nefu.project1.dao.VendorDao;
import com.nefu.project1.entity.Table_Vendor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/getAllVendor")
public class getAllVendor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VendorDao vendorDao = new VendorDao();
        List<Table_Vendor> table_vendorList = vendorDao.getAllVendor();
        List<Table_Vendor> list = new LinkedList<>();

        for (Table_Vendor vendor : table_vendorList) {
            if (vendor.getFlag() != 0) {
                list.add(vendor);
            }
                }
        System.out.println(list);

            req.setAttribute("vendorList",list);

        RequestDispatcher rd = req.getRequestDispatcher("/vendor_index.jsp");//这个路径默认是去webapp下面去寻找的
        rd.forward(req,resp);
    }
}
