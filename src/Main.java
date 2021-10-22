import model.Bill;
import view.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ CHƯƠNG TRÌNH");
            System.out.println("1. Quản lý loại sản phẩm");
            System.out.println("2. Quản lý mùa của sản phẩm");
            System.out.println("3. Quản lý sản phẩm");
            System.out.println("4. Quản lý khách hàng");
            System.out.println("5. Quản lý giỏ hàng");
            System.out.println("6. Quản lý hóa đơn");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    TypeProductView.displayTypeProductView();
                    break;
                case 2:
                    SeasonProductView.displaySeasonProductView();
                    break;
                case 3:
                    try {
                        ProductView.displayProductView();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    CustomerView.displayCustomerView();
                    break;
                case 5:
                    try {
                        ShoppingCartView.displayShoppingCartView();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        BillView.displayBillView();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
