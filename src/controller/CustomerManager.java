package controller;

import model.Customer;
import storage.CustomerFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {
    ArrayList<Customer> customerList = new ArrayList<>();
    private static CustomerManager customerManager;

    public static synchronized CustomerManager getInstance(ArrayList<Customer> customerList) {
        if (customerManager == null) {
            customerManager = new CustomerManager(customerList);
        }
        return customerManager;
    }

    public Customer enterCustomerInfo() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi khách hàng: ");
        int age = scanner1.nextInt();
        System.out.print("Nhập số điện thoại khách hàng: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(id, name, age, phone);
        return customer;
    }

    public void addCustomer() throws IOException {
        Customer customer = enterCustomerInfo();
        customerList.add(customer);
        CustomerFileManager.writeFile(customerList);
    }

    public void displayAllCustomers() {
        for (Customer c : customerList
             ) {
            System.out.println(c);
        }
    }

    public CustomerManager() {
    }

    public CustomerManager(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
}
