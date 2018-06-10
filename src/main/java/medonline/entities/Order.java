package medonline.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Order {
    private int id_order;
    private int id_customer;
    private Date order_date;
    private float total;

    public Order() {
    }

    public Order(int id_order, int id_customer, Date order_date, float total) {
        this.id_order = id_order;
        this.id_customer = id_customer;
        this.order_date = order_date;
        this.total = total;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id_order=" + id_order +
                ", id_customer=" + id_customer +
                ", order_date=" + order_date +
                ", total=" + total +
                '}';
    }

    public static Order initResultSet(Order order, ResultSet resultSet) throws SQLException {
        order.setId_order(resultSet.getInt("id_order"));
        order.setId_customer(resultSet.getInt("id_customer"));
        order.setOrder_date(resultSet.getDate("order_date"));
        order.setTotal(resultSet.getFloat("total"));
        return order;
    }
}
