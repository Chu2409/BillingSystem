package dto;

public class Product {
    
    private String productId;
    private String name;
    private double price;
    private String measureUnit;
    private boolean iva;
    private int amount;

    public Product(String productId, String name, double price, String measureUnit, boolean iva, int amount) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.measureUnit = measureUnit;
        this.iva = iva;
        this.amount = amount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        String ivaAux = iva ? "aplica" : "no aplica";
        return "Id: " + productId + " || Nombre: " + name + " || Precio: " + price + " || Unidad de medida: " + measureUnit + " || Iva: " + ivaAux + " || Cantidad: " + amount;
    }
}
