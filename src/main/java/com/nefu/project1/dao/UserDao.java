package com.nefu.project1.dao;

import com.nefu.project1.entity.Table_User;
import com.nefu.project1.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDao {
    private static Connection connection = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    /**
     * 获取所有用户
     *
     * @return
     */
    public List<Table_User> getAllUser() {

        //连接准备

        List<Table_User> userList = new LinkedList<>();

        //sql语句
        String sql = " select * from Table_User ";

        connection = DBConnection.getConn();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Table_User user = new Table_User();
                user.setUSER_ID(rs.getInt("USER_ID"));
                user.setPwd(rs.getString("pwd"));
                user.setFlag(rs.getInt("flag"));
                user.setUserName(rs.getString("userName"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * 插入一个用户
     *
     * @param user
     * @return
     */
    public int insertUser(Table_User user) {
        int flag = 0;
        try {
            String sql = " insert into Table_User(userName,pwd,flag) values (?,?,?) ";
            connection = DBConnection.getConn();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPwd());
            ps.setInt(3, 1);//标志位默认为1
            flag = ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            release(connection, ps, rs);
        }
        return flag;
    }


    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    public int updateUser(Table_User user) {
        int flag = 0;
        try {
            String sql = " update Table_User set userName = ?,pwd = ? ,flag = ? where USER_ID = ? ";
            connection = DBConnection.getConn();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPwd());
            ps.setInt(3, user.getFlag());
            ps.setInt(4, user.getUSER_ID());
            flag = ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            release(connection, ps, rs);
        }
        return flag;
    }


    /**
     * 释放资源
     *
     * @param conn 连接对象
     * @param ps   显示对象
     * @param rs   结果集对象
     */
    private void release(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 依据id查询用户
     *
     * @param id
     * @return
     */

    public Table_User getUserByID(int id) {

        Table_User user = new Table_User();

        try {

            String sql = " select * " +
                    " from Table_User where USER_ID = ? ";

            connection = DBConnection.getConn();
            ps = connection.prepareStatement(sql);


            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                user.setUSER_ID(rs.getInt("USER_ID"));
                user.setPwd(rs.getString("pwd"));
                user.setFlag(rs.getInt("flag"));
                user.setUserName(rs.getString("userName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(connection, ps, rs);
        }
        return user;
    }

    /**
     * 根据用户名和密码查找用户
     * @param userName
     * @param password
     */
    public Table_User findUserByNameAndPassword(String userName,String password) {
        Table_User user = null;
        try {
            connection = DBConnection.getConn();
            String sql = "select * from table_user where userName = ? and pwd = ? ";
            ps = connection.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()) {
                user = new Table_User();
                user.setUSER_ID(rs.getInt("USER_ID"));
                user.setUserName(rs.getString("userName"));
                user.setPwd(rs.getString("pwd"));
                user.setFlag(rs.getInt("flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return user;
    }
}
