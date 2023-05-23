package domain;

import dto.*;
import java.util.LinkedList;
import java.util.List;

public class Bill {
    
    private Customer customer;
    private FacturationSystemManager sm;
    private List<Product> products;
    private List<Service> services;
    private double subtotal;
    private double total;

    public Bill(Customer customer, FacturationSystemManager sm) {
        this.sm = sm;
        this.customer = customer;
        this.products = new LinkedList<>();
        this.services = new LinkedList<>();
        this.subtotal = 0;
        this.total = 0;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public FacturationSystemManager getSm() {
        return sm;
    }

    public void setSm(FacturationSystemManager sm) {
        this.sm = sm;
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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
