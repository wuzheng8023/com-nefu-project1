package com.nefu.project1.entity;


import java.io.Serializable;

public class Table_Dept implements Serializable {

    private int Dept_id;
    private String Dept_name;
    private String Dept_description;
    private int flag;

    public int getDept_id() {
        return Dept_id;
    }

    public void setDept_id(int dept_id) {
        Dept_id = dept_id;
    }

    public String getDept_name() {
        return Dept_name;
    }

    public void setDept_name(String dept_name) {
        Dept_name = dept_name;
    }

    public String getDept_description() {
        return Dept_description;
    }

    public void setDept_description(String dept_description) {
        Dept_description = dept_description;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Table_Dept{" +
                "Dept_id=" + Dept_id +
                ", Dept_name='" + Dept_name + '\'' +
                ", Dept_description='" + Dept_description + '\'' +
                ", flag=" + flag +
                '}';
    }
}
