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

@WebServlet("/updateVendor")
public class updateVendor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VendorDao vendorDao = new VendorDao();
        Table_Vendor vendor = new Table_Vendor();
        vendor.setVendor_phone( req.getParameter("vendor_phone"));
        vendor.setVendor_name(req.getParameter("vendor_name"));
        vendor.setVendor_id(Integer.parseInt(req.getParameter("vendor_id")));
        vendor.setVendor_fax( req.getParameter("vendor_fax"));
        vendor.setVendor_contact_person( req.getParameter("vendor_contact_person"));
        vendor.setVendor_address( req.getParameter("vendor_address"));
//        vendor.setFlag(Integer.parseInt(  req.getParameter("flag")));
        vendor.setFlag(1);
        vendorDao.updateVendor(vendor);

        resp.sendRedirect("getAllVendor");

    }
}
