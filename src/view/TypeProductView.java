package view;

import controller.TypeProductManager;
import model.TypeProduct;
import storage.TypeProductFileManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TypeProductView {
    public static void main(String[] args) {
        ArrayList<TypeProduct> typeProductList = null;
        typeProductList = TypeProductFileManager.readFile();
        TypeProductManager typeProductManager = new TypeProductManager(typeProductList);

        Scanner scannerInt = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ LOẠI SẢN PHẨM");
            System.out.println("1. Thêm loại sản phẩm");
            System.out.println("2. Hiển thị toàn bộ thông tin loại sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    try {
                        typeProductManager.addTypeProduct();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    typeProductManager.displayAllTypeProducts();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
