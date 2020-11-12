package com.nefu.project1;

import com.nefu.project1.dao.Bill_ItemDao;
import com.nefu.project1.entity.Table_bill_item;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zsy
 * @date 2020/11/10 0010 - 16:23
 */
public class BillItemTest {
    Bill_ItemDao dao = new Bill_ItemDao();
    @Test
    public void test_update() throws SQLException {
        Table_bill_item item = new Table_bill_item();
        item.setBill_item_id(1);
        item.setDept_id(1);
        item.setBill_id(1);
        item.setBill_item_Expense(2000);
        item.setFlag(1);
        int flag = dao.update(item);
        System.out.println(flag);
    }

    @Test
    public void test_insert() throws SQLException {
        Table_bill_item item = new Table_bill_item();
        item.setBill_id(1);
        item.setDept_id(1);
        item.setBill_item_Expense(1000);
        int flag = dao.insert(item);
        System.out.println(flag);
    }

    @Test
    public void test_findOne() throws SQLException {
        Table_bill_item item = dao.findOne(1);
        System.out.println(item);
    }

    @Test
    public void test_findAll() throws SQLException {
        List<Table_bill_item> list = dao.findAll();
        System.out.println(list);
    }
}
