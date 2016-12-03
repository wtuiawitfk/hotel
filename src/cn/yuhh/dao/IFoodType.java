package cn.yuhh.dao;

import cn.yuhh.entity.FoodType;

/**
 * Created by Brill on 2016/12/3.
 */
public interface IFoodType {

    void add(FoodType foodType);

    void delete(int id);

    void updata(int id);

}
