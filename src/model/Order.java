package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private String id;
    Customer customer;
    ArrayList<ShoppingCart> shoppingCartList;

    public Order() {
    }

    public Order(String id, Customer customer, ArrayList<ShoppingCart> shoppingCartList) {
        this.id = id;
        this.customer = customer;
        this.shoppingCartList = shoppingCartList;
    }

    public Order(String id, ArrayList<ShoppingCart> shoppingCartList) {
        this.id = id;
        this.shoppingCartList = shoppingCartList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(ArrayList<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer=" + customer.getId_Customer() +
                ", shoppingCartList=" + shoppingCartList +
                '}';
    }
}
