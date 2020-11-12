package com.nefu.project1.servlet.vendorservlet;

import com.nefu.project1.dao.VendorDao;
import com.nefu.project1.entity.Table_Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/insertVendor")
public class insertVendor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VendorDao vendorDao = new VendorDao();
        Table_Vendor vendor = new Table_Vendor();
        vendor.setVendor_phone( req.getParameter("Vendor_phone"));
        vendor.setVendor_name(req.getParameter("Vendor_name"));
        vendor.setVendor_id(Integer.parseInt(req.getParameter("Vendor_id")));
        vendor.setVendor_fax( req.getParameter("Vendor_fax"));
        vendor.setVendor_contact_person( req.getParameter("Vendor_contact_person"));
        vendor.setVendor_address( req.getParameter("Vendor_address"));
        vendor.setFlag(Integer.parseInt(  req.getParameter("flag")));
        vendorDao.insertVendor(vendor);
        List<Table_Vendor> table_vendorList = vendorDao.getAllVendor();
        List<Table_Vendor> list = new LinkedList<>();

        for (Table_Vendor vendor1 : table_vendorList) {
            if (vendor.getFlag() != 0) {
                list.add(vendor);
            }
        }
//        req.setAttribute("vendorList", table_vendorList);
        req.setAttribute("vendorList", list);

//        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/index.jsp");//这个路径默认是去webapp下面去寻找的
//        rd.forward(req,resp);

    }
}
