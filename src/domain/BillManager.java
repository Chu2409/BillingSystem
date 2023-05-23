package domain;

import dto.Product;
import utilities.Message;

public class BillManager {
    private Bill bill;

    public BillManager(Bill bill) {
        this.bill = bill;
    }

    public boolean addProduct(int productIndex) {
        try {
            return bill.getProducts().add(bill.getSm().buyProduct(productIndex));
        } catch (Exception e) {
            Message.print(Message.Product.PRODUCT_ERROR.toString());
            return false;
        }
    }
    
     public boolean addService(int serviceIndex) {
        try {
            return bill.getServices().add(bill.getSm().buyService(serviceIndex));
        } catch (Exception e) {
            Message.print(Message.Product.PRODUCT_ERROR.toString());
            return false;
        }
    }
    
    
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
}
