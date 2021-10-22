package view;

import controller.CustomerManager;
import model.Customer;
import storage.CustomerFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {
    public static void displayCustomerView() {
        ArrayList<Customer> customerList = null;
        try {
            customerList = CustomerFileManager.readFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        CustomerManager customerManager = new CustomerManager(customerList);

        Scanner scannerInt = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int index;
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ KHÁCH HÀNG");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Sửa thông tin khách hàng");
            System.out.println("3. Xóa thông tin khách hàng");
            System.out.println("4. Hiển thị toàn bộ thông tin khách hàng");
            System.out.println("0. Quay lại");
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
                    System.out.println("Danh sách khách hàng hiện tại");
                    for (Customer c : customerList
                         ) {
                        System.out.println(c);
                    }
                    System.out.print("Nhập mã khách hàng muốn sửa: ");
                    String id = scanner.nextLine();
                    System.out.println("Nhập các thông tin để sửa");
                    Customer customer = customerManager.enterCustomerInfo();
                    try {
                        customerManager.editCustomer(id, customer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Danh sách khách hàng hiện tại");
                    for (int i = 0; i < customerList.size(); i++) {
                        System.out.println(i + ". " + customerList.get(i));
                    }
                    System.out.print("Nhập vị trí khách hàng muốn xóa: ");
                    index = scannerInt.nextInt();
                    try {
                        customerManager.deleteCustomer(index);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    customerManager.displayAllCustomers();
                    break;
                case 0:
            }
        }
    }
}
