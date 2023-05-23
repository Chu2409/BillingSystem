package domain;

import dto.*;
import java.util.LinkedList;
import java.util.List;

public class Bill {
    private FacturationSystem system;
    private Customer customer;
    private List<Product> products;
    private List<Service> services;

    public Bill(Customer customer, FacturationSystem system) {
        this.system = system;
        this.customer = customer;
        this.products = new LinkedList<>();
        this.services = new LinkedList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
