package com.nefu.project1.servlet.vendorservlet;

import com.nefu.project1.dao.VendorDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goUpdateVendor")
public class goUpdateVendor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String income_id = req.getParameter("vendor_id");
        VendorDao vendorDao = new VendorDao();

        req.setAttribute("vendor", vendorDao.getVendorByID(Integer.parseInt(income_id)));
        req.getRequestDispatcher("/vendor_update.jsp").forward(req, resp);

    }
}
