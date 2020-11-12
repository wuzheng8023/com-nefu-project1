package com.nefu.project1.servlet.billservlet;

import com.nefu.project1.dao.VendorDao;
import com.nefu.project1.entity.Table_Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 录入界面
 * @author zsy
 * @date 2020/11/11 0011 - 9:33
 */
@WebServlet("/toEntryPageBill")
public class ToEntryPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        VendorDao vendorDao = new VendorDao();
        List<Table_Vendor> list = vendorDao.getAllVendor();
        request.setAttribute("list_Vendor",list);
        request.getRequestDispatcher("/bill_entry.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.doPost(request, response);
    }
}
