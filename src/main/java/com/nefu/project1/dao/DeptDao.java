package com.nefu.project1.dao;


import com.nefu.project1.entity.Table_Dept;
import com.nefu.project1.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author zsy
 * @date 2020/11/10 0010 - 11:06
 */
public class DeptDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * 更新部门信息
     *
     * @param dept
     * @return
     * @throws SQLException
     */
    public int update(Table_Dept dept) throws SQLException {
        int flag = 0;
        try {
            String sql = "update table_dept set Dept_name = ? ,Dept_description = ? where Dept_id = ?";
            conn = DBConnection.getConn();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, dept.getDept_name());
            ps.setString(2, dept.getDept_description());
            ps.setInt(3, dept.getDept_id());
            flag = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            ps.close();
            conn.close();
        }
        return flag;
    }

    /**
     * 插入部门信息
     *
     * @param dept
     * @return
     * @throws SQLException
     */
    public int insert(Table_Dept dept) throws SQLException {
        int flag = 0;
        try {
            String sql = " insert into table_dept(dept_name, dept_description,flag) values (?,?,?)";
            conn = DBConnection.getConn();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, dept.getDept_name());
            ps.setString(2, dept.getDept_description());
            ps.setInt(3, 1);
            flag = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            ps.close();
            conn.close();
        }
        return flag;
    }

    /**
     * 查询一个部门信息
     *
     * @param id
     * @return
     */
    public Table_Dept findOne(int id) throws SQLException {
        Table_Dept dept = null;
        try {
            String sql = " select Dept_id,Dept_name,Dept_description,flag from table_dept where Dept_id = ? ";
            conn = DBConnection.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                dept = new Table_Dept();
                dept.setDept_id(rs.getInt("Dept_id"));
                dept.setDept_name(rs.getString("Dept_name"));
                dept.setDept_description(rs.getString("Dept_description"));
                dept.setFlag(rs.getInt("flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return dept;
    }

    /**
     * 返回所有的部门信息
     * @return
     * @throws SQLException
     */
    public List<Table_Dept> findAll() throws SQLException {
        List<Table_Dept> list = new ArrayList<>();
        try {
            String sql = " select Dept_id,Dept_name,Dept_description,flag from table_dept ";
            conn = DBConnection.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Table_Dept dept = new Table_Dept();
                dept.setDept_id(rs.getInt("Dept_id"));
                dept.setDept_name(rs.getString("Dept_name"));
                dept.setDept_description(rs.getString("Dept_description"));
                dept.setFlag(rs.getInt("flag"));
                list.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return list;
    }
}
