package com.nefu.project1.servlet.billservlet;

import com.nefu.project1.dao.BillDao;
import com.nefu.project1.dao.DeptDao;
import com.nefu.project1.dao.VendorDao;
import com.nefu.project1.entity.Table_Dept;
import com.nefu.project1.entity.Table_Vendor;
import com.nefu.project1.entity.Table_bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zsy
 * @date 2020/11/11 0011 - 10:37
 */
@WebServlet("/toAddPageDeptItem")
public class ToAddPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 接收数据
        String Vendor_id = request.getParameter("select_Vendor");
        // 获取对应供应商
        VendorDao vendorDao = new VendorDao();
        Table_Vendor table_vendor = vendorDao.getVendorByID(Integer.parseInt(Vendor_id));

        String Bill_date = request.getParameter("Bill_date");
        String Bill_due_Date = request.getParameter("Bill_due_Date");
        // 设置session保留二次跳转数据
        HttpSession session = request.getSession();
        // 获取新添加的bill的主键
        Table_bill table_bill = new Table_bill();
        table_bill.setVendor_id(Integer.parseInt(Vendor_id));
        table_bill.setBill_date(Date.valueOf(Bill_date));
        table_bill.setBill_due_Date(Date.valueOf(Bill_due_Date));
        // 默认值，为0代表未支付
        table_bill.setBill_paid_flag(0);
        // 默认值，为1代表未删除
        table_bill.setFlag(1);
        BillDao billDao = new BillDao();
        try {
            int Bill_id = billDao.insert(table_bill);
            // System.out.println("Bill_id" + Bill_id);
            // 查询出最新插入的账单信息
            Table_bill bill = billDao.findOne(Bill_id);
            // System.out.println("Table_bill" + bill);
            // 设置到session中
            session.setAttribute("table_bill", bill);
            session.setAttribute("table_vendor", table_vendor);
            DeptDao deptDao = new DeptDao();
            List<Table_Dept> dept_list = deptDao.findAll();
            // System.out.println(dept_list);
            request.setAttribute("dept_list", dept_list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // System.out.println(Vendor_id);
        request.getRequestDispatcher("/bill_entry_amount.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.doPost(request, response);
    }
}
