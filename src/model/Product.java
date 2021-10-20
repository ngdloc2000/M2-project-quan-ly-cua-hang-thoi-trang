package model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String gender;
    private TypeProduct type;
    private SeasonProduct season;
    private int price;
    private int quantity;
    private String description;

    public Product() {
    }

    public Product(String id, String name, String gender, TypeProduct type, SeasonProduct season, int price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.season = season;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public TypeProduct getType() {
        return type;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SeasonProduct getSeason() {
        return season;
    }

    public void setSeason(SeasonProduct season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", gender='" + gender + '\'' +
//                ", type=" + type.getName() +
//                ", season=" + season.getName() +
//                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
