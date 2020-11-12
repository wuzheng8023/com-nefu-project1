package com.nefu.project1.servlet.billservlet;

import com.nefu.project1.dao.BillDao;
import com.nefu.project1.dao.Bill_ItemDao;
import com.nefu.project1.entity.Table_bill;
import com.nefu.project1.entity.Table_bill_item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author zsy
 * @date 2020/11/11 0011 - 16:19
 */
@WebServlet("/addBill")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] check_Value = request.getParameterValues("checkboxs");
        HttpSession session = request.getSession();
        Table_bill table_bill = (Table_bill) session.getAttribute("table_bill");
        // 查询总额度
        int total_money = 0;
        Bill_ItemDao bill_itemDao = new Bill_ItemDao();
        // 创建对应的账单项
        for (String s : check_Value) {
            Table_bill_item table_bill_item = new Table_bill_item();
            // 默认为1,表示未删除
            table_bill_item.setFlag(1);
            int checkValue = Integer.parseInt(s);
            table_bill_item.setDept_id(checkValue);
            String str_Value = request.getParameter(s);
            int int_Value = Integer.parseInt(str_Value);
            table_bill_item.setBill_id(table_bill.getBill_id());
            total_money += int_Value;
            System.out.println(int_Value);
            table_bill_item.setBill_item_Expense(int_Value);
            // 调用Bill_ItemDao持久层方法插入数据
            try {
                bill_itemDao.insert(table_bill_item);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            // 更新bill表中的总额
            BillDao billDao = new BillDao();
            billDao.update(table_bill.getBill_id(), total_money);
            System.out.println(billDao.findOne(table_bill.getBill_id()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
       response.sendRedirect("toEntryPageBill");
        // System.out.println(table_bill);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.doPost(request, response);
    }
}
