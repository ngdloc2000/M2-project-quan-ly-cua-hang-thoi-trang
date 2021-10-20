package view;

import controller.ShoppingCartManager;
import model.ShoppingCart;
import storage.ProductFileManager;
import storage.ShoppingCartFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartView {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<ShoppingCart> shoppingCartList = null;
//        shoppingCartList = ShoppingCartFileManager.readFile();
        ShoppingCartManager shoppingCartManager = new ShoppingCartManager();

        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------------------");
            System.out.println("QUẢN LÝ GIỎ HÀNG");
            System.out.println("1. Thêm sản phẩm vào giỏ hàng");
            System.out.println("2. Sửa giỏ hàng");
            System.out.println("3. Xóa giỏ hàng");
            System.out.println("4. Hiển thị toàn bộ thông tin giỏ hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(ProductFileManager.readFile());
                    System.out.print("Nhập ID khách hàng: ");
                    String idCustomer = scannerString.nextLine();
                    System.out.print("Nhập ID sản phẩm: ");
                    String idProduct = scannerString.nextLine();
                    System.out.print("Nhập số lượng: ");
                    int quantity = scannerInt.nextInt();
                    shoppingCartManager.addShoppingCart(idCustomer, idProduct, quantity);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Danh sách giỏ hàng hiện tại");
                    shoppingCartManager.displayAllShoppingCart();
                    System.out.print("Nhập mã khách hàng: ");
                    String id = scannerString.nextLine();
                    shoppingCartManager.deleteShoppingCart(id);
                    break;
                case 4:
                    shoppingCartManager.displayAllShoppingCart();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
