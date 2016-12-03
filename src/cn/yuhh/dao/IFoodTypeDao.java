package cn.yuhh.dao;

import cn.yuhh.entity.FoodType;

import java.util.List;

/**
 * Created by Brill on 2016/12/3.
 */
public interface IFoodTypeDao {

    void add(FoodType foodType);

    void delete(int id);

    void updata(FoodType ft);

    List<FoodType> query();

    FoodType findById(int id);

    List<FoodType> query(String keyword);

    Integer getFistType();

}
