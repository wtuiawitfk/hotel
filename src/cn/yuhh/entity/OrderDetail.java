package cn.yuhh.entity;

/**
 * Created by Brill on 2016/12/3.
 */
public class OrderDetail {
    private int id;
    private int orderId;
    private int food_id;
    private int foodCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", food_id=" + food_id +
                ", foodCount=" + foodCount +
                '}';
    }
}
