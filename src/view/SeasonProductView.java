package view;

import controller.SeasonProductManager;
import model.SeasonProduct;
import model.TypeProduct;
import storage.SeasonProductFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SeasonProductView {
    public static void main(String[] args) {
        ArrayList<SeasonProduct> seasonProductList = null;
        seasonProductList = SeasonProductFileManager.readFile();

        SeasonProductManager seasonProductManager = new SeasonProductManager(seasonProductList);
        Scanner scannerInt = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ MÙA CỦA SẢN PHẨM");
            System.out.println("1. Thêm mùa cho sản phẩm");
            System.out.println("2. Sửa thông tin của mùa sản phẩm");
            System.out.println("3. Xóa mùa sản phẩm");
            System.out.println("4. Hiển thị toàn bộ thông tin các mùa");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scannerInt.nextInt();
            Scanner scanner = new Scanner(System.in);

            switch (choice) {
                case 1:
                    try {
                        seasonProductManager.addSeasonProduct();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Danh sách các mùa sản phẩm hiện tại");
                    for (SeasonProduct sp : seasonProductList
                    ) {
                        System.out.println(sp);
                    }
                    System.out.print("Nhập mã mùa sản phẩm muốn sửa: ");
                    String id = scanner.nextLine();
                    System.out.println("Nhập các thông tin để sửa");
                    SeasonProduct seasonProduct = seasonProductManager.enterSeasonProductInfo();
                    try {
                        seasonProductManager.editSeasonProduct(id, seasonProduct);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Danh sách các mùa hiện tại");
                    for (int i = 0; i < seasonProductList.size(); i++) {
                        System.out.println(i + ". " + seasonProductList.get(i));
                    }
                    System.out.print("Nhập vị trí loại sản phẩm muốn xóa: ");
                    int index = scannerInt.nextInt();
                    try {
                        seasonProductManager.deleteSeasonProduct(index);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    seasonProductManager.displayAllSeasonProducts();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
