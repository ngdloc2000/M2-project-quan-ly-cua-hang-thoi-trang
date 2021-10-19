package storage;

import model.ShoppingCart;
import model.TypeProduct;

import java.io.*;
import java.util.ArrayList;

public class ShoppingCartFileManager {
    public static ArrayList<ShoppingCart> readFile()  {
        File file = new File("shoppingcart.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() > 0) {
            FileInputStream fis = null;
            ArrayList<ShoppingCart> list = new ArrayList<>();
            try {
                fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object object = ois.readObject();
                list = (ArrayList<ShoppingCart>) object;
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return list;
        } else return new ArrayList<>();
    }

    public static void writeFile(ArrayList<ShoppingCart> shoppingCarts) throws IOException {
        FileOutputStream fos = new FileOutputStream("shoppingcart.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(shoppingCarts);
        fos.close();
    }
}
