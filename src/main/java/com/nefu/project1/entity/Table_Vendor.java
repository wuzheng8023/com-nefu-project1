package com.nefu.project1.entity;

import java.io.Serializable;
import java.util.List;

public class Table_Vendor implements Serializable {

    private int Vendor_id;
    private String Vendor_name;
    private String Vendor_address;
    private String Vendor_phone;
    private String Vendor_fax; //传真
    private String Vendor_contact_person; //供货商联系人

    private int flag;

    public int getVendor_id() {
        return Vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        Vendor_id = vendor_id;
    }

    public String getVendor_name() {
        return Vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        Vendor_name = vendor_name;
    }

    public String getVendor_address() {
        return Vendor_address;
    }

    public void setVendor_address(String vendor_address) {
        Vendor_address = vendor_address;
    }

    public String getVendor_phone() {
        return Vendor_phone;
    }

    public void setVendor_phone(String vendor_phone) {
        Vendor_phone = vendor_phone;
    }

    public String getVendor_fax() {
        return Vendor_fax;
    }

    public void setVendor_fax(String vendor_fax) {
        Vendor_fax = vendor_fax;
    }

    public String getVendor_contact_person() {
        return Vendor_contact_person;
    }

    public void setVendor_contact_person(String vendor_contact_person) {
        Vendor_contact_person = vendor_contact_person;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }


    @Override
    public String toString() {
        return "Table_Vendor{" +
                "Vendor_id=" + Vendor_id +
                ", Vendor_name='" + Vendor_name + '\'' +
                ", Vendor_address='" + Vendor_address + '\'' +
                ", Vendor_phone='" + Vendor_phone + '\'' +
                ", Vendor_fax='" + Vendor_fax + '\'' +
                ", Vendor_contact_person='" + Vendor_contact_person + '\'' +
                ", flag=" + flag +
                '}';
    }
}
