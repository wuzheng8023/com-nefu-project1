package com.nefu.project1.entity;

import java.io.Serializable;

public class Table_bill_item implements Serializable {

    private int Bill_item_id;
    private int  Bill_item_Expense;//金额大小
    private int Bill_id;
    private int Dept_id;

    private int flag;

    public int getBill_item_id() {
        return Bill_item_id;
    }

    public void setBill_item_id(int bill_item_id) {
        Bill_item_id = bill_item_id;
    }

    public int getBill_item_Expense() {
        return Bill_item_Expense;
    }

    public void setBill_item_Expense(int bill_item_Expense) {
        Bill_item_Expense = bill_item_Expense;
    }

    public int getBill_id() {
        return Bill_id;
    }

    public void setBill_id(int bill_id) {
        Bill_id = bill_id;
    }

    public int getDept_id() {
        return Dept_id;
    }

    public void setDept_id(int dept_id) {
        Dept_id = dept_id;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Table_bill_item{" +
                "Bill_item_id=" + Bill_item_id +
                ", Bill_item_Expense=" + Bill_item_Expense +
                ", Bill_id=" + Bill_id +
                ", Dept_id=" + Dept_id +
                ", flag=" + flag +
                '}';
    }
}
