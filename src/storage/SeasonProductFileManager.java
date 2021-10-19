package storage;

import model.SeasonProduct;
import model.TypeProduct;

import java.io.*;
import java.util.ArrayList;

public class SeasonProductFileManager {
    public static ArrayList<SeasonProduct> readFile() {
        File file = new File("seasonproduct.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() > 0) {
            FileInputStream fis = null;
            ArrayList<SeasonProduct> list = new ArrayList<>();
            try {
                fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object object = ois.readObject();
                list = (ArrayList<SeasonProduct>) object;
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return list;
        } else return new ArrayList<>();
    }

    public static void writeFile(ArrayList<SeasonProduct> seasonProducts) throws IOException {
        FileOutputStream fos = new FileOutputStream("seasonproduct.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(seasonProducts);
        fos.close();
    }
}
