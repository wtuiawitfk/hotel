package cn.yuhh.dao;

import cn.yuhh.entity.OrderDetail;
import cn.yuhh.entity.Orders;

import java.util.List;

/**
 * Created by Brill on 2016/12/3.
 */
public interface IOrderDetailDao {

    void add(Orders orders);

    void delete(int id);

    void updata(OrderDetail orderDetail);

    List<Orders> query();

    List<Orders> query(String keyword);

    Orders findById(int id);

}
