package com.nefu.project1.dao;

import com.nefu.project1.entity.Table_Vendor;
import com.nefu.project1.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class VendorDao {

    private static Connection connection = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    /**
     * 依据名称查询指定供货商
     *
     * @param vname
     * @return
     */

    public Table_Vendor getVendorByName(String vname) {

        Table_Vendor vendor = new Table_Vendor();

        try {
            String sql = " select * " +
                    " from Table_Vendor where Vendor_name = ? ";

            connection = DBConnection.getConn();
            ps = connection.prepareStatement(sql);

            ps.setString(1, vname);
            rs = ps.executeQuery();

            if (rs.next()) {
                vendor.setFlag(rs.getInt("flag"));
                vendor.setVendor_address(rs.getString("Vendor_address"));
                vendor.setVendor_contact_person(rs.getString("Vendor_contact_person"));
                vendor.setVendor_fax(rs.getString("Vendor_fax"));
                vendor.setVendor_id(rs.getInt("Vendor_id"));
                vendor.setVendor_name(rs.getString("Vendor_name"));
                vendor.setVendor_phone(rs.getString("Vendor_phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(connection, ps, rs);
        }
        return vendor;
    }

    /**
     * 依据id查询账单
     *
     * @param id
     * @return
     */

    public Table_Vendor getVendorByID(int id) {

        Table_Vendor vendor = new Table_Vendor();

        try {

            String sql = " select * " +
                    " from Table_Vendor where Vendor_id = ? ";

            connection = DBConnection.getConn();
            ps = connection.prepareStatement(sql);


            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                vendor.setFlag(rs.getInt("flag"));
                vendor.setVendor_address(rs.getString("Vendor_address"));
                vendor.setVendor_contact_person(rs.getString("Vendor_contact_person"));
                vendor.setVendor_fax(rs.getString("Vendor_fax"));
                vendor.setVendor_id(rs.getInt("Vendor_id"));
                vendor.setVendor_name(rs.getString("Vendor_name"));
                vendor.setVendor_phone(rs.getString("Vendor_phone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(connection, ps, rs);
        }
        return vendor;
    }


    /**
     * 查找所有供货商
     *
     * @return
     */

    public List<Table_Vendor> getAllVendor() {
        List<Table_Vendor> vendorList = new LinkedList<>();

        //sql语句
        String sql = " select * from Table_Vendor ";

        connection = DBConnection.getConn();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Table_Vendor vendor = new Table_Vendor();
                vendor.setFlag(rs.getInt("flag"));
                vendor.setVendor_address(rs.getString("Vendor_address"));
                vendor.setVendor_contact_person(rs.getString("Vendor_contact_person"));
                vendor.setVendor_fax(rs.getString("Vendor_fax"));
                vendor.setVendor_id(rs.getInt("Vendor_id"));
                vendor.setVendor_name(rs.getString("Vendor_name"));
                vendor.setVendor_phone(rs.getString("Vendor_phone"));
                vendorList.add(vendor);
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
        return vendorList;
    }


    /**
     * 插入一个供应商
     *
     * @param vendor
     * @return
     */
    public int insertVendor(Table_Vendor vendor) {
        int flag = 0;
        try {
            String sql = " insert into Table_Vendor (Vendor_name,Vendor_address,Vendor_phone,Vendor_fax,Vendor_contact_person,flag) values (?,?,?,?,?,?) ";
            connection = DBConnection.getConn();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);

            ps.setString(1, vendor.getVendor_name());
            ps.setString(2, vendor.getVendor_address());
            ps.setString(3, vendor.getVendor_phone());
            ps.setString(4, vendor.getVendor_fax());
            ps.setString(5, vendor.getVendor_contact_person());
            ps.setInt(6, 1);//标志位默认为1
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
     * 更新供应商信息,同时设置标志位
     *
     * @param vendor
     * @return
     */
    public int updateVendor(Table_Vendor vendor) {
        int flag = 0;
        try {
            String sql = " update Table_Vendor set Vendor_name = ?,Vendor_address = ?,Vendor_phone = ?,Vendor_fax = ?,Vendor_contact_person = ?,flag = ? where Vendor_id = ? ";
            connection = DBConnection.getConn();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);

            ps.setString(1, vendor.getVendor_name());
            ps.setString(2, vendor.getVendor_address());
            ps.setString(3, vendor.getVendor_phone());
            ps.setString(4, vendor.getVendor_fax());
            ps.setString(5, vendor.getVendor_contact_person());
            ps.setInt(6, vendor.getFlag());
            ps.setInt(7, vendor.getVendor_id());

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

}
