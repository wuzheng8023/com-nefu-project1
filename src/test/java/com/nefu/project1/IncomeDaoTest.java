package com.nefu.project1;

import com.nefu.project1.dao.IncomeDao;
import com.nefu.project1.entity.Table_Income;
import com.nefu.project1.entity.Table_User;
import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;

public class IncomeDaoTest {

  private IncomeDao incomeDao = new IncomeDao();

    @Test
    public void test_getIncome() {
        for (Table_Income income : incomeDao.getAllIncome()) {
            System.out.println(income);
        }

    }

    @Test
    public void test_insertIncome() {
        Table_Income table_income = new Table_Income();
//        private int Income_id;
//
//        private int Dept_id;
//        private int Daily_income;  //本日收入
//        private Date Business_date;
//        private Timestamp Lst_mod_timestemp;//该记录的最新修改时间
//
//        private int flag;
//        Date.valueOf("1998-08-08");
        table_income.setBusiness_date( Date.valueOf("1999-9-9"));
        table_income.setDept_id(1);
        incomeDao.insertIncome(table_income);


    }

    @Test
    public void test_updateIncome() {

        Table_Income table_income = incomeDao.getAllIncome().get(0);
        table_income.setDaily_income(888);
        incomeDao.updateIncome(table_income);

    }

    @Test
    public void test_getIncomeByID() {

        Table_Income table_income = incomeDao.getIncomeByID(2);
        System.out.println(table_income);
    }
}
