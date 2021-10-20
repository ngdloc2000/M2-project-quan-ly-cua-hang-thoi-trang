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
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ LOẠI SẢN PHẨM");
            System.out.println("1. Thêm loại sản phẩm");
            System.out.println("2. Sửa thông tin loại sản phẩm");
            System.out.println("3. Xóa loại sản phẩm");
            System.out.println("4. Hiển thị toàn bộ thông tin loại sản phẩm");
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
                    System.out.println("Danh sách loại sản phẩm hiện tại");
                    for (TypeProduct tp : typeProductList
                    ) {
                        System.out.println(tp);
                    }
                    System.out.print("Nhập mã loại sản phẩm muốn sửa: ");
                    String id = scanner.nextLine();
                    System.out.println("Nhập các thông tin để sửa");
                    TypeProduct typeProduct = typeProductManager.enterTypeProductInfo();
                    try {
                        typeProductManager.editTypeProduct(id, typeProduct);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Danh sách các loại sản phẩm hiện tại");
                    for (int i = 0; i < typeProductList.size(); i++) {
                        System.out.println(i + ". " + typeProductList.get(i));
                    }
                    System.out.print("Nhập vị trí loại sản phẩm muốn xóa: ");
                    int index = scannerInt.nextInt();
                    try {
                        typeProductManager.deleteTypeProduct(index);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    typeProductManager.displayAllTypeProducts();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
