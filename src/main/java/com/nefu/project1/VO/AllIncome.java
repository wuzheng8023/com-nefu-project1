package com.nefu.project1.VO;

import com.nefu.project1.entity.Table_Income;

public class AllIncome {
    private Table_Income income;
    private String deptName;

    @Override
    public String toString() {
        return "AllIncome{" +
                "income=" + income +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Table_Income getIncome() {
        return income;
    }

    public void setIncome(Table_Income income) {
        this.income = income;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
