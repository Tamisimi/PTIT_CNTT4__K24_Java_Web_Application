package session02.bai03;

import java.util.Date;

public class Order {
    private String orderId;
    private String productName;
    private double totalAmount;
    private Date orderDate;

    public Order(String orderId, String productName, double totalAmount, Date orderDate) {
        this.orderId = orderId;
        this.productName = productName;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public String getOrderId() { return orderId; }
    public String getProductName() { return productName; }
    public double getTotalAmount() { return totalAmount; }
    public Date getOrderDate() { return orderDate; }
}
