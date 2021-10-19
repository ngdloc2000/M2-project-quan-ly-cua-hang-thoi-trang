package storage;

import model.Customer;
import model.SeasonProduct;

import java.io.*;
import java.util.ArrayList;

public class CustomerFileManager {
    public static ArrayList<Customer> readFile() throws IOException, ClassNotFoundException {
        File file = new File("customer.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            ArrayList<Customer> list = (ArrayList<Customer>) object;
            ois.close();
            return list;
        } else return new ArrayList<>();
    }

    public static void writeFile(ArrayList<Customer> customers) throws IOException {
        FileOutputStream fos = new FileOutputStream("customer.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(customers);
        fos.close();
    }
}
