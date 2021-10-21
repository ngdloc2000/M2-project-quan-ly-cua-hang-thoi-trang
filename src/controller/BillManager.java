package controller;

import model.Bill;
import model.Customer;
import model.ShoppingCart;
import storage.BillFileManager;
import storage.ShoppingCartFileManager;

import java.io.IOException;
import java.util.ArrayList;

public class BillManager {
    ArrayList<Bill> billList = new ArrayList<>();
    ArrayList<ShoppingCart> shoppingCartList = ShoppingCartFileManager.readFile();

    public int chargeACart(String customerId) throws IOException {
        Customer customer;
        for (int i = 0; i < shoppingCartList.size(); i++) {
            customer = shoppingCartList.get(i).getCustomer();
            if (customer.getId_Customer().equals(customerId) && shoppingCartList.get(i).isPaid() == false) {
                int sum = 0;
                for (int j = 0; j < shoppingCartList.get(i).getProductCartList().size(); j++) {
                    int amountAProduct = shoppingCartList.get(i).getProductCartList().get(j).getQuantity() * shoppingCartList.get(i).getProductCartList().get(j).getPrice();
                    sum += amountAProduct;
                    shoppingCartList.get(i).setPaid(true);
                    ShoppingCartFileManager.writeFile(shoppingCartList);
                }
                return sum;
            } else if (customer.getId_Customer().equals(customerId) && shoppingCartList.get(i).isPaid() != false) {
                System.out.println("Không có giỏ hàng nào");
            }
        }
        return 0;
    }

    public Customer chooseCustomer(String id) {
        for (int i = 0; i < shoppingCartList.size(); i++) {
            if (shoppingCartList.get(i).getCustomer().getId_Customer().equals(id)) {
                return shoppingCartList.get(i).getCustomer();
            }
        }
        return null;
    }

    public void creatBill(String billId, String customerId) throws IOException {
        int totalMoney = chargeACart(customerId);
        Customer customer = chooseCustomer(customerId);
        Bill bill = new Bill(billId, customer, totalMoney, shoppingCartList);
        billList.add(bill);
        BillFileManager.writeFile(billList);
    }

    public void displayAllBill() {
        for (Bill b : billList
        ) {
            System.out.println(b);
        }
    }

    public BillManager() throws IOException, ClassNotFoundException {
        this.shoppingCartList = shoppingCartList;
    }

    public ArrayList<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(ArrayList<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    @Override
    public String toString() {
        return "BillManager{" +
                "shoppingCartList=" + shoppingCartList +
                '}';
    }
}
