package storage;

import model.Product;
import model.TypeProduct;

import java.io.*;
import java.util.ArrayList;

public class ProductFileManager {
    public static ArrayList<Product> readFile() throws IOException, ClassNotFoundException {
        File file = new File("product.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            ArrayList<Product> list = (ArrayList<Product>) object;
            ois.close();
            return list;
        } else return new ArrayList<>();
    }

    public static void writeFile(ArrayList<Product> products) throws IOException {
        FileOutputStream fos = new FileOutputStream("product.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(products);
        fos.close();
    }
}
