package com.nefu.project1;

import com.nefu.project1.dao.DeptDao;
import com.nefu.project1.entity.Table_Dept;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zsy
 * @date 2020/11/10 0010 - 11:23
 */
public class DeptTest {
    private DeptDao deptDao = new DeptDao();
    @Test
    public void test_insert() throws SQLException {
        Table_Dept dept = new Table_Dept();
        dept.setDept_name("部门1");
        dept.setDept_description("描述1");
        int flag = deptDao.insert(dept);
        System.out.println(flag);
    }

    @Test
    public void test_update() throws SQLException {
        Table_Dept dept = new Table_Dept();
        dept.setDept_id(1);
        dept.setDept_name("部门2");
        dept.setDept_description("描述2");
        int flag = deptDao.update(dept);
        System.out.println(flag);
    }

    @Test
    public void test_findOne() throws SQLException {
        Table_Dept dept = deptDao.findOne(1);
        System.out.println(dept);
    }

    @Test
    public void test_findAll() throws SQLException {
        List<Table_Dept> list = deptDao.findAll();
        System.out.println(list);
    }
}
