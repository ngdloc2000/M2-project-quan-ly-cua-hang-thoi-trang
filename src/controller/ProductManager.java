package controller;

import model.Product;
import model.SeasonProduct;
import model.TypeProduct;
import storage.ProductFileManager;
import storage.SeasonProductFileManager;
import storage.TypeProductFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> productList = ProductFileManager.readFile();
    ArrayList<TypeProduct> typeProductList = TypeProductFileManager.readFile();
    ArrayList<SeasonProduct> seasonProductList = SeasonProductFileManager.readFile();

    public SeasonProduct getSeasonProductByID(String idOldArray, ArrayList<SeasonProduct> seasonProductList) {
        for (int i = 0; i < seasonProductList.size(); i++) {
            if (seasonProductList.get(i).getId().equals(idOldArray)) {
                return seasonProductList.get(i);
            }
        }
        return null;
    }

    public void updateSeasonProduct() throws IOException {
        for (int i = 0; i < productList.size() - 1; i++) {
            String idOldArray = productList.get(i).getSeason().getId();
            SeasonProduct seasonProductNew = getSeasonProductByID(idOldArray, seasonProductList);
            productList.get(i).setSeason(seasonProductNew);
            ProductFileManager.writeFile(productList);
        }
    }

    public TypeProduct findTypeProductByID(String id) {
        for (TypeProduct tp : typeProductList
        ) {
            if (tp.getId().equals(id)) {
                return tp;
            }
        }
        return null;
    }

    public SeasonProduct findSeasonProductByID(String id) {
        for (SeasonProduct sp : seasonProductList
        ) {
            if (sp.getId().equals(id)) {
                return sp;
            }
        }
        return null;
    }

    public Product enterProductInfo() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giới tính của sản phẩm: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập giá cho sản phẩm: ");
        int price = scanner1.nextInt();
        System.out.print("Nhập số lượng cho sản phẩm: ");
        int quantity = scanner1.nextInt();
        System.out.print("Nhập mô tả cho sản phẩm: ");
        String description = scanner.nextLine();


        System.out.println("Nhập mã thể loại cho sản phầm: ");
        System.out.println(TypeProductFileManager.readFile());
        TypeProduct type = new TypeProduct();
        String typeInput = scanner.nextLine();
        if (findTypeProductByID(typeInput) == null) {
            System.out.println("Không có thể loại sản phẩm này!!!");
        } else {
            type = findTypeProductByID(typeInput);
        }


        System.out.println("Nhập mã mùa cho sản phầm: ");
        System.out.println(SeasonProductFileManager.readFile());
        SeasonProduct season = new SeasonProduct();
        String seasonInput = scanner.nextLine();
        if (findSeasonProductByID(seasonInput) == null) {
            System.out.println("Không có mùa này!!!");
        } else {
            season = findSeasonProductByID(seasonInput);
        }

        Product product = new Product(id, name, gender, type, season, price, quantity, description);
        return product;
    }

    public void addProduct() throws IOException {
        Product product = enterProductInfo();
        productList.add(product);
        ProductFileManager.writeFile(productList);
    }

    public void editProduct(String id, Product product) throws IOException {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.get(i).setId(product.getId());
                productList.get(i).setName(product.getName());
                productList.get(i).setGender(product.getGender());
                productList.get(i).setType(product.getType());
                productList.get(i).setSeason(product.getSeason());
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setQuantity(product.getQuantity());
                productList.get(i).setDescription(product.getDescription());
                ProductFileManager.writeFile(productList);
            }
        }
    }

    public void deleteProduct(int index) throws IOException {
        productList.remove(index);
        ProductFileManager.writeFile(productList);
    }

    public void displayAllProducts() {
        for (Product p : productList
        ) {
            System.out.println(p);
        }
    }

    public void sortProductByQuantity() {
        for (int i = 1; i < productList.size(); i++) {
            for (int j = 0; j < productList.size() - i; j++) {
                if (productList.get(j).getQuantity() > productList.get(j + 1).getQuantity()) {
                    Product temp = productList.get(j);
                    productList.set(j,productList.get(j+1));
                    productList.set(j+1, temp);
                }
            }
        }

        System.out.println("Danh sách sản phẩm sau khi sắp xếp theo số lượng");
        for (Product p : productList) {
            System.out.println(p);
        }
    }

    public void sortProductByPrice() {
        for (int i = 1; i < productList.size(); i++) {
            for (int j = 0; j < productList.size() - i; j++) {
                if (productList.get(j).getPrice() > productList.get(j + 1).getPrice()) {
                    Product temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }

        System.out.println("Danh sách sản phẩm sau khi sắp xếp theo giá sản phẩm");
        for (Product p : productList) {
            System.out.println(p);
        }
    }

    public ProductManager() throws IOException, ClassNotFoundException {
    }

    public ProductManager(ArrayList<Product> productList) throws IOException, ClassNotFoundException {
        this.productList = productList;
    }

    public ProductManager(ArrayList<Product> productList, ArrayList<TypeProduct> typeProductList, ArrayList<SeasonProduct> seasonProductList) throws IOException, ClassNotFoundException {
        this.productList = productList;
        this.typeProductList = typeProductList;
        this.seasonProductList = seasonProductList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<TypeProduct> getTypeProductList() {
        return typeProductList;
    }

    public void setTypeProductList(ArrayList<TypeProduct> typeProductList) {
        this.typeProductList = typeProductList;
    }

    public ArrayList<SeasonProduct> getSeasonProductList() {
        return seasonProductList;
    }

    public void setSeasonProductList(ArrayList<SeasonProduct> seasonProductList) {
        this.seasonProductList = seasonProductList;
    }

    @Override
    public String toString() {
        return "ProductManager{" +
                "productList=" + productList +
                ", typeProductList=" + typeProductList +
                ", seasonProductList=" + seasonProductList +
                '}';
    }
}
