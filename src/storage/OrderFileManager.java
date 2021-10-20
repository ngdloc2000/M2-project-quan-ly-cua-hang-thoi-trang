package storage;

import model.Order;
import model.Product;

import java.io.*;
import java.util.ArrayList;

public class OrderFileManager {
    public static ArrayList<Order> readFile() throws IOException, ClassNotFoundException {
        File file = new File("order.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            ArrayList<Order> list = (ArrayList<Order>) object;
            ois.close();
            return list;
        } else return new ArrayList<>();
    }

    public static void writeFile(ArrayList<Order> orders) throws IOException {
        FileOutputStream fos = new FileOutputStream("order.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(orders);
        fos.close();
    }
}
