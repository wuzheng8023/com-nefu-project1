package com.nefu.project1;

import com.nefu.project1.dao.BillDao;
import com.nefu.project1.entity.Table_bill;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


/**
 * @author zsy
 * @date 2020/11/10 0010 - 14:31
 */
public class BillTest {
    BillDao dao = new BillDao();

    @Test
    public void test_update() throws SQLException {
        Table_bill bill = new Table_bill();
        bill.setBill_id(1);
        bill.setVendor_id(1);
        bill.setBill_date(Date.valueOf("1999-01-19"));
        bill.setBill_due_Date(Date.valueOf("1999-09-01"));
        bill.setBill_paid_flag(0);
        bill.setBill_amount(50000);
        bill.setFlag(1);
        int flag = dao.update(bill);
        System.out.println(flag);
    }

    @Test
    public void test_insert() throws SQLException {
        Table_bill bill = new Table_bill();
        bill.setVendor_id(1);
        bill.setBill_date(Date.valueOf("1999-01-19"));
        bill.setBill_due_Date(Date.valueOf("1999-09-01"));
        bill.setBill_paid_flag(1);
        bill.setBill_amount(20000);
        bill.setFlag(1);
        dao.insert(bill);
    }

    @Test
    public void test_findOne() throws SQLException {
        Table_bill bill = dao.findOne(1);
        System.out.println(bill);
    }

    @Test
    public void test_findAll() throws SQLException {
        List<Table_bill> list = dao.findAll();
        System.out.println(list);
    }
}
