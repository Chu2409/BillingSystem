package domain;

import dto.*;
import java.util.LinkedList;
import java.util.List;

public class FacturationSystem {

    private List<Customer> customers;
    private List<Product> products;
    private List<Service> services;

    public FacturationSystem() {
        this.customers = new LinkedList<>();
        this.products = new LinkedList<>();
        this.services = new LinkedList<>();
    }

    public FacturationSystem(List<Product> products) {
        this.products = products;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
