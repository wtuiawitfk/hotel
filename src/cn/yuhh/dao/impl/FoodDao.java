package cn.yuhh.dao.impl;

import cn.yuhh.dao.IFoodDao;
import cn.yuhh.entity.Food;
import cn.yuhh.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Brill on 2016/12/3.
 */
public class FoodDao implements IFoodDao {

    private QueryRunner qr = JdbcUtils.getQuerrRunner();

    @Override
    public void add(Food food) {
        String sql = "insert food(foodName,foodType_id,price,mprice,remark,img) VALUES(?,?,?,?,?,?)";
        try {
            qr.update(sql, food.getFoodName(), food.getFoodType_id(), food.getPrice(),
                    food.getmPrice(), food.getRemark(), food.getImg());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM food WHERE id=?";
        try {
            qr.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updata(Food food) {
        try {
            String sql ="UPDATE food SET foodName=?,foodType_id=?,price=?,mPrice=?,remark=?,img=? WHERE id =?";
            qr.update(sql,food.getFoodName(),food.getFoodType_id(),food.getPrice(),
                    food.getmPrice(),food.getRemark(),food.getImg(),food.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Food> query() {
        String sql = "select * from food";
        try {
            return qr.query(sql, new BeanListHandler<Food>(Food.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Food findById(int id) {
        String sql = "select * from food where id=?";
        try {
            return qr.query(sql, new BeanHandler<Food>(Food.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Food query(String keyword) {
        String sql = "select * from food where foodName like ?";
        try {
            return qr.query(sql, new BeanHandler<Food>(Food.class), "%" + keyword + "%");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Food> findByType(int type) {
        String sql = "select * from food where foodType_id=?";
        try {
            return qr.query(sql, new BeanListHandler<Food>(Food.class), type);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
