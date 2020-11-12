package com.nefu.project1.entity;

import java.io.Serializable;

public class Table_User  implements Serializable {
    private int USER_ID;
    private String userName;
    private String pwd;
    private int flag;


    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Table_User{" +
                "USER_ID=" + USER_ID +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", flag=" + flag +
                '}';
    }
}
