package controller;

import model.Product;
import model.ShoppingCart;
import storage.ProductFileManager;

import java.io.IOException;
import java.util.ArrayList;

public class ShoppingCartManager {
    ArrayList<Product> productList = ProductFileManager.readFile();
    ShoppingCart shoppingCart;
    ProductManager productManager = ProductManager.getInstance(productList);
    ArrayList<ShoppingCart> shoppingCartList = new ArrayList<>();
    ArrayList<Product> productManagerList = productManager.getProductList();

    public ShoppingCartManager(ArrayList<ShoppingCart> shoppingCartList) throws IOException, ClassNotFoundException {
    }

    public ShoppingCartManager(ShoppingCart shoppingCart, ProductManager productManager, ArrayList<ShoppingCart> shoppingCartList, ArrayList<Product> productManagerList) throws IOException, ClassNotFoundException {
        this.shoppingCart = shoppingCart;
        this.productManager = productManager;
        this.shoppingCartList = shoppingCartList;
        this.productManagerList = productManagerList;
    }

    public Product chooseProduct(String idProduct) {
        for (int i = 0; i < productManagerList.size(); i++) {
            if (productManagerList.get(i).getId().equals(idProduct)) {
                return productManagerList.get(i);
            }
        }
        return null;
    }

    public void addToCart(String idProduct) throws IOException {
        Product product = chooseProduct(idProduct);
        System.out.println(product);
//        shoppingCartList.add(product);
//        ShoppingCartFileManager.writeFile(shoppingCartList);
    }

    public void displayAllCart() {
        for (ShoppingCart sp : shoppingCartList) {
            System.out.println(sp);
        }
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ArrayList<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(ArrayList<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    public ArrayList<Product> getProductManagerList() {
        return productManagerList;
    }

    public void setProductManagerList(ArrayList<Product> productManagerList) {
        this.productManagerList = productManagerList;
    }

    @Override
    public String toString() {
        return "ShoppingCartManager{" +
                "shoppingCart=" + shoppingCart +
                ", productList=" + productManagerList +
                '}';
    }
}
