package dto;

public class Service {
    private String serviceId;
    private String name;
    private double price;
    private boolean iva;

    public Service(String serviceId, String name, double price, boolean iva) {
        this.serviceId = serviceId;
        this.name = name;
        this.price = price;
        this.iva = iva;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Service{" + "serviceId=" + serviceId + ", name=" + name + ", price=" + price + ", iva=" + iva + '}';
    }
}
