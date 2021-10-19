package controller;

import model.TypeProduct;
import storage.TypeProductFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TypeProductManager {
    ArrayList<TypeProduct> typeProductList = new ArrayList<>();

    public TypeProduct enterTypeProductInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã loại sản phẩm: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên loại sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập mô tả sản phẩm: ");
        String description = scanner.nextLine();
        TypeProduct typeProduct = new TypeProduct(id, name, description);
        return typeProduct;
    }

    public void addTypeProduct() throws IOException {
        TypeProduct typeProduct = enterTypeProductInfo();
        typeProductList.add(typeProduct);
        TypeProductFileManager.writeFile(typeProductList);
    }

    public void displayAllTypeProducts() {
        for (TypeProduct t : typeProductList
        ) {
            System.out.println(t);
        }
    }

    public TypeProductManager() {
    }

    public TypeProductManager(ArrayList<TypeProduct> typeProductList) {
        this.typeProductList = typeProductList;
    }

    public ArrayList<TypeProduct> getTypeProductList() {
        return typeProductList;
    }

    public void setTypeProductList(ArrayList<TypeProduct> typeProductList) {
        this.typeProductList = typeProductList;
    }
}
