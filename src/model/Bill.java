package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Bill implements Serializable {
    private String id;
    Customer customer;
    private int totalMoney;
    ArrayList<ShoppingCart> shoppingCartList;

    public Bill(String id, Customer customer, int totalMoney, ArrayList<ShoppingCart> shoppingCartList) {
        this.id = id;
        this.customer = customer;
        this.totalMoney = totalMoney;
        this.shoppingCartList = shoppingCartList;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", customer=" + customer.getName() +
                ", totalMoney=" + totalMoney +
                ", shoppingCartList=" + shoppingCartList +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
