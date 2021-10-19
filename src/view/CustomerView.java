package view;

import controller.CustomerManager;
import controller.TypeProductManager;
import model.Customer;
import model.Product;
import model.TypeProduct;
import storage.CustomerFileManager;
import storage.TypeProductFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {
    public static void main(String[] args) {
        ArrayList<Customer> customerList = null;
        try {
            customerList = CustomerFileManager.readFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        CustomerManager customerManager = new CustomerManager(customerList);

        Scanner scannerInt = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ KHÁCH HÀNG");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị toàn bộ thông tin khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    try {
                        customerManager.addCustomer();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    customerManager.displayAllCustomers();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
