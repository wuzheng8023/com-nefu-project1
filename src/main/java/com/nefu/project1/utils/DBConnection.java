package com.nefu.project1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接类
 */
public  class DBConnection {
    private static Connection connection= null;
    private static String url = "jdbc:mysql://localhost/comnefuproject1?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user = "root";
    private static String pwd = "123456";
    private static String drvier = "com.mysql.cj.jdbc.Driver";
    public static Connection getConn(){
        try {
            Class.forName(drvier);
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
