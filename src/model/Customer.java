package model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String id_Customer;
    private String name;
    private int age;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String id_Customer, String name, int age, String phoneNumber) {
        this.id_Customer = id_Customer;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getId_Customer() {
        return id_Customer;
    }

    public void setId_Customer(String id_Customer) {
        this.id_Customer = id_Customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id_Customer='" + id_Customer + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
