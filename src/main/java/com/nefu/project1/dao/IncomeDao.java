package com.nefu.project1.dao;

import com.nefu.project1.entity.Table_Income;
import com.nefu.project1.utils.DBConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class IncomeDao {

    private static Connection connection = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;



    /**
     * 依据id查询账单
     * @param id
     * @return
     */
    public Table_Income getIncomeByID(int id) {

        Table_Income income = new Table_Income();

        try {

            String sql = " select * " +
                    " from Table_Income where Income_id = ? ";

            connection = DBConnection.getConn();
            ps = connection.prepareStatement(sql);


            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                income.setIncome_id(rs.getInt("Income_id"));
                income.setDept_id(rs.getInt("Dept_id"));
                income.setBusiness_date(rs.getDate("Business_date"));
                income.setDaily_income(rs.getInt("Daily_income"));
                income.setLst_mod_timestemp(rs.getTimestamp("Lst_mod_timestemp"));
                income.setFlag(rs.getInt("flag"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(connection, ps, rs);
        }
        return income;
    }


    /**
     * 查找所有收入账单
     *
     * @return
     */
    public List<Table_Income> getAllIncome() {
        List<Table_Income> incomeList = new LinkedList<>();

        //sql语句
        String sql = " select * from Table_Income ";

        connection = DBConnection.getConn();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Table_Income income = new Table_Income();

                income.setIncome_id(rs.getInt("Income_id"));
                income.setDept_id(rs.getInt("Dept_id"));
                income.setBusiness_date(rs.getDate("Business_date"));
                income.setDaily_income(rs.getInt("Daily_income"));
                income.setLst_mod_timestemp(rs.getTimestamp("Lst_mod_timestemp"));
                income.setFlag(rs.getInt("flag"));

                incomeList.add(income);
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
        return incomeList;

    }


    /**
     * 插入一个收入
     *
     * @param income
     * @return
     */
    public int insertIncome(Table_Income income) {
        int flag = 0;
        try {
            String sql = " insert into Table_Income (Dept_id,Daily_income,Business_date,flag) values (?,?,?,?) ";
            connection = DBConnection.getConn();
            connection.setAutoCommit(false);

            ps = connection.prepareStatement(sql);

            ps.setInt(1, income.getDept_id());
            ps.setInt(2, income.getDaily_income());
            ps.setDate(3, income.getBusiness_date());
            ps.setInt(4, 1);//标志位默认为1

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
     * 更新收入信息,同时设置标志位
     *
     * @param income
     * @return
     */
    public int updateIncome(Table_Income income) {
        int flag = 0;
        try {
            String sql = " update Table_Income set Dept_id = ? , Daily_income = ? , Business_date = ? , flag = ? where Income_id = ? ";
            connection = DBConnection.getConn();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);

            ps.setInt(1, income.getDept_id());
            ps.setInt(2, income.getDaily_income());
            ps.setDate(3, income.getBusiness_date());
            ps.setInt(4, income.getFlag());
            ps.setInt(5, income.getIncome_id());
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
