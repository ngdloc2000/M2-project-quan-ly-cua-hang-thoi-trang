package controller;

import model.Customer;
import model.Product;
import model.ShoppingCart;
import storage.CustomerFileManager;
import storage.ProductFileManager;
import storage.ShoppingCartFileManager;

import java.io.IOException;
import java.util.ArrayList;

public class ShoppingCartManager {
    ArrayList<ShoppingCart> shoppingCartList = ShoppingCartFileManager.readFile();
    ArrayList<Product> cartList = new ArrayList<>();
    ArrayList<Product> productList = ProductFileManager.readFile();
    ArrayList<Customer> customerList = CustomerFileManager.readFile();

    public ShoppingCartManager(ArrayList<ShoppingCart> shoppingCartList) throws IOException, ClassNotFoundException {
    }

    public ShoppingCartManager() throws IOException, ClassNotFoundException {

    }

    public ArrayList<Product> addToCart(String idProduct, int quantity) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(idProduct)) {
                Product productOld = productList.get(i);
                Product productNew = new Product(productOld.getId(), productOld.getName(), productOld.getGender(), productOld.getType(), productOld.getSeason(), productOld.getPrice(), quantity, productOld.getDescription());
                productOld.setQuantity(productOld.getQuantity() - quantity);
                cartList.add(productNew);
                try {
                    ProductFileManager.writeFile(productList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return cartList;
            }
        }
        return null;
    }

    public Customer chooseCustomer(String idCustomer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId_Customer().equals(idCustomer)) {
                return customerList.get(i);
            }
        }
        return null;
    }

    public void addShoppingCartList(String idCustomer, String idProduct, int quantity) throws IOException {
        ArrayList<Product> productCartList = addToCart(idProduct, quantity);
        Customer customer = chooseCustomer(idCustomer);
        ShoppingCart shoppingCart = new ShoppingCart(customer, productCartList);
        shoppingCartList.add(shoppingCart);
        ShoppingCartFileManager.writeFile(shoppingCartList);
    }

    public void displayAllShoppingCart() {
        for (ShoppingCart sp : shoppingCartList) {
            System.out.println(sp);
        }
    }

    public ArrayList<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(ArrayList<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    public ArrayList<Product> getCartList() {
        return cartList;
    }

    public void setCartList(ArrayList<Product> cartList) {
        this.cartList = cartList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public String toString() {
        return "ShoppingCartManager{" +
                "shoppingCartList=" + shoppingCartList +
                ", cartList=" + cartList +
                ", productList=" + productList +
                ", customerList=" + customerList +
                '}';
    }
}
