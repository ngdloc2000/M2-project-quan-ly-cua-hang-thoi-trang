package controller;

import model.Customer;
import model.SeasonProduct;
import storage.SeasonProductFileManager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SeasonProductManager {
    ArrayList<SeasonProduct> seasonProductList = new ArrayList<>();

    public SeasonProduct enterSeasonProductInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã mùa: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên mùa: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày bắt đầu: ");
        String start = scanner.nextLine();
        System.out.print("Nhập ngày kết thúc: ");
        String end = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        System.out.print("Nhập mô tả mùa: ");
        String description = scanner.nextLine();
        SeasonProduct seasonProduct = new SeasonProduct(id, name, startDate, endDate, description);
        return seasonProduct;
    }

    public void addSeasonProduct() throws IOException {
        SeasonProduct seasonProduct = enterSeasonProductInfo();
        seasonProductList.add(seasonProduct);
        SeasonProductFileManager.writeFile(seasonProductList);
    }

    public void displayAllSeasonProducts() {
        for (SeasonProduct s : seasonProductList
        ) {
            System.out.println(s);
        }
    }

    public SeasonProductManager() {
    }

    public SeasonProductManager(ArrayList<SeasonProduct> seasonProductList) {
        this.seasonProductList = seasonProductList;
    }

    public ArrayList<SeasonProduct> getSeasonProductList() {
        return seasonProductList;
    }

    public void setSeasonProductList(ArrayList<SeasonProduct> seasonProductList) {
        this.seasonProductList = seasonProductList;
    }
}
