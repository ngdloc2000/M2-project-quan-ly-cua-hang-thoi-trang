package storage;

import model.TypeProduct;

import java.io.*;
import java.util.ArrayList;

public class TypeProductFileManager {
    public static ArrayList<TypeProduct> readFile()  {
        File file = new File("typeproduct.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() > 0) {
            FileInputStream fis = null;
            ArrayList<TypeProduct> list = new ArrayList<>();
            try {
                fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object object = ois.readObject();
                list = (ArrayList<TypeProduct>) object;
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return list;
        } else return new ArrayList<>();
    }

    public static void writeFile(ArrayList<TypeProduct> typeProducts) throws IOException {
        FileOutputStream fos = new FileOutputStream("typeproduct.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(typeProducts);
        fos.close();
    }
}
