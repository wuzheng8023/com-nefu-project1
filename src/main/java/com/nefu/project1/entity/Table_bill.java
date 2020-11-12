package com.nefu.project1.entity;

import java.io.Serializable;
import java.sql.Date;

//供应商提供的那个账单
public class Table_bill implements Serializable {

    private int Bill_id;
    private int Vendor_id;
    private Date Bill_date;  //开出账单日期
    private Date Bill_due_Date;//账单到期日期
    private int Bill_paid_flag; //0代表未支付，
    private int Bill_amount;
    private int flag ;

    public int getBill_id() {
        return Bill_id;
    }

    public void setBill_id(int bill_id) {
        Bill_id = bill_id;
    }

    public int getVendor_id() {
        return Vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        Vendor_id = vendor_id;
    }

    public Date getBill_date() {
        return Bill_date;
    }

    public void setBill_date(Date bill_date) {
        Bill_date = bill_date;
    }

    public Date getBill_due_Date() {
        return Bill_due_Date;
    }

    public void setBill_due_Date(Date bill_due_Date) {
        Bill_due_Date = bill_due_Date;
    }

    public int getBill_paid_flag() {
        return Bill_paid_flag;
    }

    public void setBill_paid_flag(int bill_paid_flag) {
        Bill_paid_flag = bill_paid_flag;
    }

    public int getBill_amount() {
        return Bill_amount;
    }

    public void setBill_amount(int bill_amount) {
        Bill_amount = bill_amount;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Table_bill{" +
                "Bill_id=" + Bill_id +
                ", Vendor_id=" + Vendor_id +
                ", Bill_date=" + Bill_date +
                ", Bill_due_Date=" + Bill_due_Date +
                ", Bill_paid_flag=" + Bill_paid_flag +
                ", Bill_amount=" + Bill_amount +
                ", flag=" + flag +
                '}';
    }
}
