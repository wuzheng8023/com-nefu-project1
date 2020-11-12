package com.nefu.project1.dao;

import com.nefu.project1.entity.Table_bill;
import com.nefu.project1.entity.Table_bill_item;
import com.nefu.project1.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zsy
 * @date 2020/11/10 0010 - 16:20
 */
public class Bill_ItemDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * 更改所有信息
     * @param item
     * @return
     * @throws SQLException
     */
    public int update(Table_bill_item item) throws SQLException {
        int flag = 0;
        try {
            String sql = "update table_bill_item set Bill_id = ?,Dept_id = ?,Bill_item_Expense = ?,flag = ? where Bill_item_id = ? ";
            conn = DBConnection.getConn();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1,item.getBill_id());
            ps.setInt(2, item.getDept_id());
            ps.setInt(3,item.getBill_item_Expense());
            ps.setInt(4,item.getFlag());
            ps.setInt(5,item.getBill_item_id());
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



    public int insert(Table_bill_item item) throws SQLException {
        int flag = 0;
        try {
            String sql = " insert into table_bill_item(Bill_id, Dept_id, Bill_item_Expense, flag) values(?,?,?,?) ";
            conn = DBConnection.getConn();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getBill_id());
            ps.setInt(2, item.getDept_id());
            ps.setInt(3,item.getBill_item_Expense());
            ps.setInt(4,1);
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
     * 查询一个信息
     * @param id
     * @return
     * @throws SQLException
     */
    public Table_bill_item findOne(int id) throws SQLException {
        Table_bill_item item = null;
        try {
            String sql = " select * from table_bill_item where Bill_item_id = ? ";
            conn = DBConnection.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                item = new Table_bill_item();
                item.setBill_item_id(rs.getInt("Bill_item_id"));
                item.setBill_id(rs.getInt("Bill_id"));
                item.setDept_id(rs.getInt("Dept_id"));
                item.setBill_item_Expense(rs.getInt("Bill_item_Expense"));
                item.setFlag(rs.getInt("flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return item;
    }

    /**
     * 查询所有
     * @return
     * @throws SQLException
     */
    public List<Table_bill_item> findAll() throws SQLException {
        List<Table_bill_item> list = new ArrayList<>();
        try {
            String sql = " select * from table_bill_item ";
            conn = DBConnection.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Table_bill_item item = new Table_bill_item();
                item.setBill_item_id(rs.getInt("Bill_item_id"));
                item.setBill_id(rs.getInt("Bill_id"));
                item.setDept_id(rs.getInt("Dept_id"));
                item.setBill_item_Expense(rs.getInt("Bill_item_Expense"));
                item.setFlag(rs.getInt("flag"));
                list.add(item);
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
