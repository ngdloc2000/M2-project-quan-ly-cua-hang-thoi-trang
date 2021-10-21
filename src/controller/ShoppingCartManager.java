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

    public ShoppingCartManager() throws IOException, ClassNotFoundException {
    }

    public boolean isShoppingCartExistByIdCustomer(String id) {
        for (int i = 0; i < shoppingCartList.size(); i++) {
            if (shoppingCartList.get(i).getCustomer().getId_Customer().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void addShoppingCart(String customerId, String productId, int quantity) throws IOException {
        Customer customer = new Customer();
        Product productNew;
        if (!isShoppingCartExistByIdCustomer(customerId)) {
            for (Customer c : customerList
            ) {
                if (c.getId_Customer().equals(customerId)) {
                    customer = c;
                }
            }
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId().equals(productId)) {
                    Product productOld = productList.get(i);
                    productNew = new Product(productOld.getId(), productOld.getName(), productOld.getGender(), productOld.getType(), productOld.getSeason(), productOld.getPrice(), quantity, productOld.getDescription());
                    cartList.add(productNew);
                    productOld.setQuantity(productOld.getQuantity() - quantity);
                    ProductFileManager.writeFile(productList);
                }
            }
            ShoppingCart shoppingCart = new ShoppingCart(customer, cartList);
            shoppingCartList.add(shoppingCart);
            ShoppingCartFileManager.writeFile(shoppingCartList);
        } else if (isShoppingCartExistByIdCustomer(customerId)) {
            for (int i = 0; i < shoppingCartList.size(); i++) {
                // Khách hàng đã có trong giỏ hàng
                if (shoppingCartList.get(i).getCustomer().getId_Customer().equals(customerId)) {
                    ShoppingCart shoppingCart = shoppingCartList.get(i);
                    int index = -1;
                    for (int j = 0; j < shoppingCartList.get(i).getProductCartList().size(); j++) {
                        // Thêm sản phẩm mà sản phẩm đã có trong giỏ hàng -> set lại quantity
                        if (shoppingCart.getProductCartList().get(j).getId().equals(productId)) {
                            index = j;
                            break;

                        }
                    }
                    if(index != -1){
                        shoppingCart.getProductCartList().get(index).setQuantity(shoppingCart.getProductCartList().get(index).getQuantity() + quantity);
                        for (int z = 0; z < productList.size(); z++) {
                            if (productList.get(z).getId().equals(productId)) {
                                productList.get(z).setQuantity(productList.get(z).getQuantity() - quantity);
                                ProductFileManager.writeFile(productList);
                            }
                        }
                        ShoppingCartFileManager.writeFile(shoppingCartList);
                    }else {
                        for (int k = 0; k < productList.size(); k++) {
                            if (productList.get(k).getId().equals(productId)) {
                                Product productOld = productList.get(k);
                                Product productNew1 = new Product(productOld.getId(), productOld.getName(), productOld.getGender(), productOld.getType(), productOld.getSeason(), productOld.getPrice(), quantity, productOld.getDescription());
                                shoppingCart.getProductCartList().add(productNew1);
                                productOld.setQuantity(productOld.getQuantity() - quantity);
                                ProductFileManager.writeFile(productList);
                                ShoppingCartFileManager.writeFile(shoppingCartList);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public Customer chooseCustomer(String idCustomer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId_Customer().equals(idCustomer)) {
                return customerList.get(i);
            }
        }
        return null;
    }

    public void deleteShoppingCart(String idCustomer) throws IOException {
        for (int i = 0; i < shoppingCartList.size(); i++) {
            if (shoppingCartList.get(i).getCustomer().getId_Customer().equals(idCustomer)) {
                shoppingCartList.remove(i);
            }
        }
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
