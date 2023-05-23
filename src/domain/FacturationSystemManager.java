package domain;

import dto.*;
import utilities.*;

public class FacturationSystemManager {

    private FacturationSystem system;

    public FacturationSystemManager(FacturationSystem system) {
        this.system = system;
    }

    public boolean insertCustomer() {
        try {
            Customer c = Console.askCustomer();
            if (!verifyExistingCustomer(c.getCustomerId())) {
                Message.print(Message.Customer.CUSTOMER_ENTERED.toString());
                return this.system.getCustomers().add(c);
            }
            Message.print(Message.Customer.CUSTOMER_EXISTING.toString());
            return false;
        } catch (Exception e) {
            Message.print(Message.Customer.CUSTOMER_ERROR.toString());
            return false;
        }
    }

    public Customer getCustomerById() {
        try {
            String id = Console.askCustomerId();
            for (Customer c : this.system.getCustomers()) {
                if (c.getCustomerId().equals(id)) {
                    return c;
                }
            }
            Message.print(Message.Customer.CUSTOMER_NOTFOUND.toString());
            return null;
        } catch (Exception e) {
            Message.print(Message.Customer.CUSTOMER_ERROR.toString());
            return null;
        }
    }

    public boolean deleteCustomer() {
        try {
            var customers = this.system.getCustomers();
            String customerId = Console.askCustomerId();
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getCustomerId().equals(customerId)) {
                    customers.remove(i);
                    Message.print(Message.Customer.CUSTOMER_DELETED.toString());
                    return true;
                }
            }
            Message.print(Message.Customer.CUSTOMER_NOTFOUND.toString());
            return false;
        } catch (Exception e) {
            Message.print(Message.Customer.CUSTOMER_ERROR.toString());
            return false;
        }
    }

    public void selectCustomers() {
        int i = 1;
        for (Customer c : system.getCustomers()) {
            System.out.println(i + ": " + c);
            i++;
        }
    }

    public boolean verifyExistingCustomer(String customerId) {
        try {
            for (Customer c : this.system.getCustomers()) {
                if (c.getCustomerId().equals(customerId)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean insertProduct() {
        try {
            Product p = Console.askProduct();
            if (!verifyExistingProduct(p.getProductId())) {
                Message.print(Message.Product.PRODUCT_ENTERED.toString());
                return this.system.getProducts().add(p);
            }
            Message.print(Message.Product.PRODUCT_EXISTING.toString());
            return false;
        } catch (Exception e) {
            Message.print(Message.Product.PRODUCT_ERROR.toString());
            return false;
        }
    }

    public Product buyProduct(int index) {
        try {
            Product p = getProductByIndex(index);
            int amount = Console.askProductAmount();
            Product aux = new Product(p.getProductId(), p.getName(), p.getPrice(), p.getMeasureUnit(), p.isIva(),
                    p.getAmount());

            if (p.getAmount() > amount) {
                p.setAmount(p.getAmount() - amount);
                aux.setAmount(amount);
                return aux;
            }
            aux.setAmount(p.getAmount());
            system.getProducts().remove(index);
            return aux;
        } catch (Exception e) {
            Message.print(Message.Product.PRODUCT_ERROR.toString());
            return null;
        }
    }

    public Product getProductById() {
        try {
            String id = Console.askProductId();
            for (Product p : this.system.getProducts()) {
                if (p.getProductId().equals(id)) {
                    return p;
                }
            }
            Message.print(Message.Product.PRODUCT_NOTFOUND.toString());
            return null;
        } catch (Exception e) {
            Message.print(Message.Product.PRODUCT_ERROR.toString());
            return null;
        }
    }

    public Product getProductByIndex(int index) {
        try {
            return this.getSystem().getProducts().get(index);
        } catch (Exception e) {
            Message.print(Message.Product.PRODUCT_ERROR.toString());
            return null;
        }
    }

    public boolean deleteProduct() {
        try {
            var products = this.system.getProducts();
            String productId = Console.askProductId();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProductId().equals(productId)) {
                    products.remove(i);
                    Message.print(Message.Product.PRODUCT_DELETED.toString());
                    return true;
                }
            }
            Message.print(Message.Product.PRODUCT_NOTFOUND.toString());
            return false;
        } catch (Exception e) {
            Message.print(Message.Product.PRODUCT_ERROR.toString());
            return false;
        }
    }

    public void selectProducts() {
        int i = 1;
        for (Product p : system.getProducts()) {
            System.out.println(i + ": " + p);
            i++;
        }
    }

    public boolean verifyExistingProduct(String productId) {
        try {
            for (Product p : this.system.getProducts()) {
                if (p.getProductId().equals(productId)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean insertService() {
        try {
            Service s = Console.askService();
            if (!verifyExistingService(s.getServiceId())) {
                Message.print(Message.Service.SERVICE_ENTERED.toString());
                return this.system.getServices().add(s);
            }
            Message.print(Message.Service.SERVICE_EXISTING.toString());
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Service buyService(int index) {
        try {
            return getServiceByIndex(index);
        } catch (Exception e) {
            Message.print(Message.Product.PRODUCT_ERROR.toString());
            return null;
        }
    }

    public Service getServiceById() {
        try {
            String id = Console.askServiceId();
            for (Service s : this.system.getServices()) {
                if (s.getServiceId().equals(id)) {
                    return s;
                }
            }
            Message.print(Message.Service.SERVICE_NOTFOUND.toString());
            return null;
        } catch (Exception e) {
            Message.print(Message.Service.SERVICE_ERROR.toString());
            return null;
        }
    }

    public Service getServiceByIndex(int index) {
        try {
            return this.getSystem().getServices().get(index);
        } catch (Exception e) {
            Message.print(Message.Service.SERVICE_ERROR.toString());
            return null;
        }
    }

    public boolean deleteService() {
        try {
            var services = this.system.getServices();
            String serviceId = Console.askServiceId();
            for (int i = 0; i < services.size(); i++) {
                if (services.get(i).getServiceId().equals(serviceId)) {
                    services.remove(i);
                    Message.print(Message.Service.SERVICE_DELETED.toString());
                    return true;
                }
            }
            Message.print(Message.Service.SERVICE_NOTFOUND.toString());
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void selectServices() {
        int i = 1;
        for (Service s : system.getServices()) {
            System.out.println(i + ": " + s);
            i++;
        }
    }

    public boolean verifyExistingService(String serviceId) {
        try {
            for (Service s : this.system.getServices()) {
                if (s.getServiceId().equals(serviceId)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public FacturationSystem getSystem() {
        return system;
    }

    public void setSystem(FacturationSystem system) {
        this.system = system;
    }
}
