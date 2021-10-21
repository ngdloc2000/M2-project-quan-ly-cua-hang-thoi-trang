package storage;

import model.Bill;

import java.io.*;
import java.util.ArrayList;

public class BillFileManager {
    public static ArrayList<Bill> readFile() throws IOException, ClassNotFoundException {
        File file = new File("bill.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            ArrayList<Bill> list = (ArrayList<Bill>) object;
            ois.close();
            return list;
        } else return new ArrayList<>();
    }

    public static void writeFile(ArrayList<Bill> bills) throws IOException {
        FileOutputStream fos = new FileOutputStream("bill.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(bills);
        fos.close();
    }
}
