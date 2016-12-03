package cn.yuhh.dao;

import cn.yuhh.entity.Orders;

import java.util.List;

/**
 * Created by Brill on 2016/12/3.
 */
public interface IOrdersDao {

    void updata(Orders order);

    List<Orders> query();

    void add(Orders order);

    int getCount();

    int getTotalCount();
}
