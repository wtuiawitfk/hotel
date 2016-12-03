package cn.yuhh.dao;

import cn.yuhh.entity.Food;

import java.util.List;

/**
 * Created by Brill on 2016/12/3.
 */
public interface IFood {

    void add(Food food);

    void delete(int id);

    void updata(int id);

    List<Food> query();

    Food findById(int id);

    List<Food> query(String keyword);

    List<Food> findByType(int type);

    /**
     * 分页查询数据
     */
    //void findAll(PageBean<Food> pageBean);
}
