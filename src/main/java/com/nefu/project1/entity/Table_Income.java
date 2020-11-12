package com.nefu.project1.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
public class Table_Income implements Serializable {

    private int Income_id;

    private int Dept_id;
    private int Daily_income;  //本日收入
    private Date Business_date;
    private Timestamp Lst_mod_timestemp;

    private int flag;

    public int getIncome_id() {
        return Income_id;
    }

    public void setIncome_id(int income_id) {
        Income_id = income_id;
    }

    public int getDept_id() {
        return Dept_id;
    }

    public void setDept_id(int dept_id) {
        Dept_id = dept_id;
    }

    public int getDaily_income() {
        return Daily_income;
    }

    public void setDaily_income(int daily_income) {
        Daily_income = daily_income;
    }

    public Date getBusiness_date() {
        return Business_date;
    }

    public void setBusiness_date(Date business_date) {
        Business_date = business_date;
    }

    public Timestamp getLst_mod_timestemp() {
        return Lst_mod_timestemp;
    }

    public void setLst_mod_timestemp(Timestamp lst_mod_timestemp) {
        Lst_mod_timestemp = lst_mod_timestemp;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Table_Income{" +
                "Income_id=" + Income_id +
                ", Dept_id=" + Dept_id +
                ", Daily_income=" + Daily_income +
                ", Business_date=" + Business_date +
                ", Lst_mod_timestemp=" + Lst_mod_timestemp +
                ", flag=" + flag +
                '}';
    }
}
