package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {
    Customer customer;
    ArrayList<Product> productCartList;

    public ShoppingCart() {
    }

    public ShoppingCart(Customer customer, ArrayList<Product> productList) {
        this.customer = customer;
        this.productCartList = productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProductCartList() {
        return productCartList;
    }

    public void setProductCartList(ArrayList<Product> productCartList) {
        this.productCartList = productCartList;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "customeID = " + customer.getId_Customer() +
                ", customeName = " + customer.getName() +
                ", productList = " + productCartList +
                '}';
    }
}
