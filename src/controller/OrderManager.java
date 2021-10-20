package controller;

import model.Customer;
import model.Order;
import model.ShoppingCart;
import storage.CustomerFileManager;
import storage.OrderFileManager;
import storage.ShoppingCartFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderManager {
    ArrayList<Order> orderList = OrderFileManager.readFile();
    ArrayList<ShoppingCart> shoppingCartList = ShoppingCartFileManager.readFile();
    ArrayList<Customer> customerList = CustomerFileManager.readFile();
    ArrayList<ShoppingCart> shoppingCartAPerson = new ArrayList<>();

    Scanner scannerString = new Scanner(System.in);

    public OrderManager() throws IOException, ClassNotFoundException {
    }

    public boolean isOrderExists(String idOrder) {
        for (Order o : orderList
        ) {
            if (o.getId().equals(idOrder)) {
                return true;
            }
        }
        return false;
    }

    public Order getOrderById(String orderId) {
        for (Order o : orderList
        ) {
            if (o.getId().equals(orderId)) {
                return o;
            }
        }
        return null;
    }

    public void addOrder(String idOrder, String idCustomer) throws IOException {
        for (ShoppingCart sp : shoppingCartList
        ) {
            if (sp.getCustomer().getId_Customer().equals(idCustomer) && !isOrderExists(idOrder)) {
                Customer customer = sp.getCustomer();
                shoppingCartAPerson.add(sp);
                Order order = new Order(idOrder, customer, shoppingCartAPerson);
                orderList.add(order);
                OrderFileManager.writeFile(orderList);
            }
            if (isOrderExists(idOrder)) {

            }
        }
    }

    public void displayAllOrder() {
        for (Order o : orderList
        ) {
            System.out.println(o);
        }
    }

    @Override
    public String toString() {
        return "OrderManager{" +
                "orderList=" + orderList +
                ", shoppingCartList=" + shoppingCartList +
                ", customerList=" + customerList +
                ", scannerString=" + scannerString +
                '}';
    }

    public ArrayList<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(ArrayList<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }
}
