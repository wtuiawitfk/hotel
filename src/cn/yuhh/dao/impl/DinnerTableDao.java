package cn.yuhh.dao.impl;

import cn.yuhh.dao.IDinnerTableDao;
import cn.yuhh.entity.DinnerTable;
import cn.yuhh.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Brill on 2016/12/3.
 */
public class DinnerTableDao implements IDinnerTableDao {
    private QueryRunner queryRunner = JdbcUtils.getQuerrRunner();

    @Override
    public void add(DinnerTable dinnerTable) {
        try {
            String sql = "INSERT dinnertable(tableName) VALUES(?)";
            queryRunner.update(sql, dinnerTable.getTableName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM dinnertable WHERE id=?";
            queryRunner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updata(DinnerTable dinnerTable) {
        try {
            String sql = "UPDATE dinnertable SET tableStatus=?,orderDate=? WHERE id=?";
            Date date = dinnerTable.getOrderDate();
            queryRunner.update(sql, dinnerTable.getTableStatus(), date, dinnerTable.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DinnerTable> query() {
        String sql = "SELECT * FROM dinnertable";
        try {
            return queryRunner.query(sql, new BeanListHandler < DinnerTable > (DinnerTable.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DinnerTable findById(int id) {
        String sql = "SELECT * FROM dinnertable WHERE id=?";
        try {
            return queryRunner.query(sql, new BeanHandler<DinnerTable>(DinnerTable.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DinnerTable> query(String keyword) {
        String sql = "SELECT * FROM dinnerTable WHERE tableName LIKE ?";
        try {
            return queryRunner.query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class), "%" + keyword + "%");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void quitTable(int id) {
        String sql = "UPDATE dinnertable SET tableStatus=?,orderDate=? WHERE id=?";
        try {
            queryRunner.update(sql, 0, null, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
