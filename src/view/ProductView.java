package view;

import controller.ProductManager;
import model.Product;
import model.TypeProduct;
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
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ SẢN PHẨM");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị toàn bộ thông tin sản phẩm");
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
                    System.out.println("Danh sách sản phẩm hiện tại");
                    for (Product p : productList
                    ) {
                        System.out.println(p);
                    }
                    System.out.print("Nhập mã sản phẩm muốn sửa: ");
                    String id = scanner.nextLine();
                    System.out.println("Nhập các thông tin để sửa");
                    Product product = productManager.enterProductInfo();
                    try {
                        productManager.editProduct(id, product);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Danh sách các sản phẩm hiện tại");
                    for (int i = 0; i < productList.size(); i++) {
                        System.out.println(i + ". " + productList.get(i));
                    }
                    System.out.print("Nhập vị trí sản phẩm muốn xóa: ");
                    int index = scannerInt.nextInt();
                    try {
                        productManager.deleteProduct(index);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    productManager.displayAllProducts();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
