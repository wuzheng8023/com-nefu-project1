package com.nefu.project1.dao;

import com.nefu.project1.entity.Table_Dept;
import com.nefu.project1.entity.Table_bill;
import com.nefu.project1.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zsy
 * @date 2020/11/10 0010 - 14:21
 */
public class BillDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * 更新账单信息
     *
     * @param bill
     * @return
     * @throws SQLException
     */
    public int update(Table_bill bill) throws SQLException {
        int flag = 0;
        try {
            String sql = "update table_bill set Vendor_id = ?,Bill_date = ?,Bill_due_Date = ?, " +
                    " Bill_paid_flag = ?,Bill_amount = ?,flag = ? where Bill_id = ? ";
            conn = DBConnection.getConn();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bill.getVendor_id());
            ps.setDate(2, bill.getBill_date());
            ps.setDate(3, bill.getBill_due_Date());
            ps.setInt(4, bill.getBill_paid_flag());
            ps.setInt(5, bill.getBill_amount());
            ps.setInt(6, bill.getFlag());
            ps.setInt(7, bill.getBill_id());
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
     * 更改金额信息
     * @param id
     * @param amount
     * @return
     * @throws SQLException
     */
    public int update(int id,int amount) throws SQLException {
        int flag = 0;
        try {
            String sql = "update table_bill set Bill_amount = ? where Bill_id = ? ";
            conn = DBConnection.getConn();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1,amount);
            ps.setInt(2,id);
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
     * 插入账单信息,并返回最新插入数据的主键
     *
     * @param bill
     * @return
     * @throws SQLException
     */
    public int insert(Table_bill bill) throws SQLException {
        int id = 0;
        try {
            String sql = " insert into table_bill(Vendor_id, Bill_date, Bill_due_Date, " +
                    " Bill_paid_flag, Bill_amount, flag) values(?,?,?,?,?,?) ";
            conn = DBConnection.getConn();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            conn.setAutoCommit(false);
            ps.setInt(1, bill.getVendor_id());
            ps.setDate(2, bill.getBill_date());
            ps.setDate(3, bill.getBill_due_Date());
            ps.setInt(4, 0);
            ps.setInt(5, bill.getBill_amount());
            ps.setInt(6, 1);
            ps.executeUpdate();
            conn.commit();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            ps.close();
            conn.close();
        }
        return id;
    }


    /**
     * 查询一个账单信息
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Table_bill findOne(int id) throws SQLException {
        Table_bill bill = null;
        try {
            String sql = " select * from table_bill where Bill_id = ? ";
            conn = DBConnection.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                bill = new Table_bill();
                bill.setBill_id(rs.getInt("Bill_id"));
                bill.setVendor_id(rs.getInt("Vendor_id"));
                bill.setBill_date(rs.getDate("Bill_date"));
                bill.setBill_due_Date(rs.getDate("Bill_due_Date"));
                bill.setBill_paid_flag(rs.getInt("Bill_paid_flag"));
                bill.setBill_amount(rs.getInt("Bill_amount"));
                bill.setFlag(rs.getInt("flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return bill;
    }

    /**
     * 查询所有的账单信息
     *
     * @return
     * @throws SQLException
     */
    public List<Table_bill> findAll() throws SQLException {
        List<Table_bill> list = new ArrayList<>();
        try {
            String sql = " select * from table_bill ";
            conn = DBConnection.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Table_bill bill = new Table_bill();
                bill.setBill_id(rs.getInt("Bill_id"));
                bill.setVendor_id(rs.getInt("Vendor_id"));
                bill.setBill_date(rs.getDate("Bill_date"));
                bill.setBill_due_Date(rs.getDate("Bill_due_Date"));
                bill.setBill_paid_flag(rs.getInt("Bill_paid_flag"));
                bill.setBill_amount(rs.getInt("Bill_amount"));
                bill.setFlag(rs.getInt("flag"));
                list.add(bill);
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
