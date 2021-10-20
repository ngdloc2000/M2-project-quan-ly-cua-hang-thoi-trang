package view;

import controller.OrderManager;

import java.io.IOException;
import java.util.Scanner;

public class OrderView {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OrderManager orderManager = new OrderManager();

        Scanner scannerInt = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ HÓA ĐƠN");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Xóa thông tin hóa đơn");
            System.out.println("3. Hiển thị toàn bộ thông tin hóa đơn");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã hóa đơn: ");
                    String orderId = scanner.nextLine();
                    System.out.print("Nhập mã khách hàng: ");
                    String customerId = scanner.nextLine();
                    orderManager.addOrder(orderId, customerId);
                    break;
                case 2:
                    break;
                case 3:
                    orderManager.displayAllOrder();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
