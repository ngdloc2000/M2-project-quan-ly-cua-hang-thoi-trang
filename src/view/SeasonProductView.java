package view;

import controller.SeasonProductManager;
import model.SeasonProduct;
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
            System.out.println("2. Hiển thị toàn bộ thông tin các mùa");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    try {
                        seasonProductManager.addSeasonProduct();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    seasonProductManager.displayAllSeasonProducts();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
