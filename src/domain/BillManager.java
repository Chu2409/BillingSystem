package domain;

import dto.Product;
import dto.Service;
import utilities.Message;

public class BillManager {

    private Bill bill;

    public BillManager(Bill bill) {
        this.bill = bill;
    }

    public boolean addProduct(int productIndex) {
        try {
            if (bill.getProducts().add(bill.getSm().buyProduct(productIndex))) {
                Message.print(Message.Product.PRODUCT_ADDED.toString());
                return true;
            }
            return false;
        } catch (Exception e) {
            Message.print(Message.Product.PRODUCT_ERROR.toString());
            return false;
        }
    }

    public boolean addService(int serviceIndex) {
        try {
            if (bill.getServices().add(bill.getSm().buyService(serviceIndex))) {
                Message.print(Message.Service.SERVICE_ADDED.toString());
                return true;
            }
            return false;
        } catch (Exception e) {
            Message.print(Message.Service.SERVICE_ERROR.toString());
            return false;
        }
    }

    public double calculateProductSubtotal(Product p) {
        double subtotal = p.getPrice() * p.getAmount();
        bill.setSubtotal(bill.getSubtotal() + subtotal);
        return subtotal;
    }

    public double calculateProductTotal(double subtotal, boolean iva) {
        double total = 0;
        if (iva) {
            total = subtotal + (subtotal * 0.12);
        } else {
            total = subtotal;
        }
        bill.setTotal(bill.getTotal() + total);
        return total;
    }

    public double calculateServiceTotal(double subtotal, boolean iva) {
        double total = 0;
        if (iva) {
            total = subtotal + (subtotal * 0.12);
        } else {
            total = subtotal;
        }
        bill.setTotal(bill.getTotal() + total);
        return total;
    }

    public void printBill() {
        Message.printBillHeader(bill.getCustomer());
        Message.printBillData();
        if (bill.getProducts() != null) {
            for (Product p : bill.getProducts()) {
                double subtotal = calculateProductSubtotal(p);
                Message.printBillProducts(p.getName(), p.getPrice(), p.getAmount(), subtotal, p.isIva(), calculateProductTotal(subtotal, p.isIva()));
            }
        }
        if (bill.getServices() != null) {
            for (Service s : bill.getServices()) {
                Message.printBillServices(s.getName(), s.getPrice(), s.getPrice(), s.isIva(), calculateServiceTotal(s.getPrice(), s.isIva()));
            }
        }
        Message.printFinalBill(bill.getSubtotal(), bill.getTotal());
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

}
