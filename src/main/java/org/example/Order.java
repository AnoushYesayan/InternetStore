package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    static List<Order> list = new ArrayList<>();
    private int id;
    private String brand;
    private String orderNumber;
    private String productName;
    private double price;
    private int quantity;
    private String buyersFullName;
    private boolean wasItBoughtWithDiscount;
    private int discount;
    private String colour;
    private Category category;
    private double paid;
    private String orderStatus;

    public Order(String buyersFullName, int id, String brand, String productName, double price, int quantity,
                 boolean wasItBoughtWithDiscount, int discount, String colour, Category category, double paid,
                 String orderStatus, String orderNumber) {
        this.id = id;
        this.brand = brand;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.buyersFullName = buyersFullName;
        this.wasItBoughtWithDiscount = wasItBoughtWithDiscount;
        this.setDiscount(wasItBoughtWithDiscount, discount);
        this.colour = colour;
        this.category = category;
        this.setPaid(wasItBoughtWithDiscount, paid);
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
    }

    public static void addOrder(Order order) {
        list.add(order);
    }

    public static List<Order> getOrders() {
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    public static List<Order> getOrder(String orderNumberOrBuyersFullName) {
        List<Order> newListName = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).buyersFullName.equals(orderNumberOrBuyersFullName) || list.get(i).orderNumber
                    .equals(orderNumberOrBuyersFullName)) {
                newListName.add(list.get(i));
            }
        }
        if (newListName.isEmpty()) {
            return null;
        }
        return newListName;
    }

    public static List<Order> paging(int itemsPerPage, int page) {
        List<Order> orderOfPage = new ArrayList<>();
        for (int i = itemsPerPage - page - 1; i < itemsPerPage * page; i++) {
            orderOfPage.add(list.get(i));
        }
        return orderOfPage;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(boolean wasItBoughtWithDiscount, double paid) {
        if (wasItBoughtWithDiscount) {
            this.paid = this.price - (this.price * this.discount / 100);
        } else {
            this.paid = paid;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBuyersFullName() {
        return buyersFullName;
    }

    public void setBuyersFullName(String buyersFullName) {
        this.buyersFullName = buyersFullName;
    }

    public boolean isWasItBoughtWithDiscount() {
        return wasItBoughtWithDiscount;
    }

    public void setWasItBoughtWithDiscount(boolean wasItBoughtWithDiscount) {
        this.wasItBoughtWithDiscount = wasItBoughtWithDiscount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(boolean wasItBoughtWithDiscount, int discount) {
        if (wasItBoughtWithDiscount) {
            this.discount = discount;
        } else {
            this.discount = 0;
        }
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return '\n' +
                "id: " + id + '\n' +
                "brand: " + brand + '\n' +
                "productName: " + productName + '\n' +
                "quantity: " + quantity + '\n' +
                "price: " + price + '\n' +
                "buyersFullName: " + buyersFullName + '\n' +
                "wasItBoughtWithDiscount: " + wasItBoughtWithDiscount + '\n' +
                "discount: " + discount + '\n' +
                "colour: " + colour + '\n' +
                "category: " + category + '\n' +
                "paid: " + paid;
    }

    public Order getId(int id) {
        List<Integer> getId = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                return list.get(i);
            }
        }
        return null;
    }
}