package view;

import controller.BillManager;

import java.io.IOException;
import java.util.Scanner;

public class BillView {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BillManager billManager = new BillManager();


        Scanner scannerInt = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        String customerId;
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ HÓA ĐƠN");
            System.out.println("1. Tạo hóa đơn cho khách hàng");
            System.out.println("2. Hiển thị toàn bộ hóa đơn");
            System.out.println("3. Chi tiết thông tin của 1 khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã khách hàng: ");
                    customerId = scanner.nextLine();
                    System.out.print("Nhập mã hóa đơn: ");
                    String billId = scanner.nextLine();
                    billManager.creatBill(billId, customerId);
                    break;
                case 2:
                    billManager.displayAllBill();
                    break;
                case 3:
                    System.out.print("Nhập mã khách hàng: ");
                    customerId = scanner.nextLine();
                    System.out.println("THÔNG TIN KHÁCH HÀNG");
                    billManager.displayInfoAPersonById(customerId);
                    System.out.println("Số lượng hóa đơn của khách hàng là: " + billManager.countBillAPersonById(customerId));
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
