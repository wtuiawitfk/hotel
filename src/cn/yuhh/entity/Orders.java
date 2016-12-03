package cn.yuhh.entity;

import java.util.Date;

/**
 * Created by Brill on 2016/12/3.
 */
public class Orders {
    private int id;
    private int table_id;
    private Date drderDate;
    private double totelPrice;
    private int orderStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public Date getDrderDate() {
        return drderDate;
    }

    public void setDrderDate(Date drderDate) {
        this.drderDate = drderDate;
    }

    public double getTotelPrice() {
        return totelPrice;
    }

    public void setTotelPrice(double totelPrice) {
        this.totelPrice = totelPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", table_id=" + table_id +
                ", drderDate=" + drderDate +
                ", totelPrice=" + totelPrice +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
