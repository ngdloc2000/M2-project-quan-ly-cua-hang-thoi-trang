package view;

import controller.ProductManager;
import model.Product;
import storage.ProductFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {
    public static void main(String[] args) {
        ArrayList<Product> productList = null;
        try {
            productList = ProductFileManager.readFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ProductManager productManager = new ProductManager(productList);

        Scanner scannerInt = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ SẢN PHẨM");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị toàn bộ thông tin sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    try {
                        productManager.addProduct();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    productManager.displayAllProducts();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
