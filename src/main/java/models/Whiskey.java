package models;

public class Whiskey {
    private int id;
    private String name;
    private String brand;
    private double alcConcentration;
    private double size;
    private double price;
    private int qty;

    public Whiskey() {}

    public Whiskey(int id, String name, String brand, double alcConcentration, double size, double price, int qty) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.alcConcentration = alcConcentration;
        this.size = size;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getAlcConcentration() {
        return alcConcentration;
    }

    public void setAlcConcentration(double alcConcentration) {
        this.alcConcentration = alcConcentration;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return String.format("{Product id: %d," +
                "Product name: %s," +
                "Product brand: %s,"+
                "Product Alcohol Concentration: %.2f," +
                "Product size: %.2f,"+
                "Product price: %.2f," +
                "Product quantity: %d}",
                getId(),getName(),getBrand(),getAlcConcentration(),getSize(),getPrice(),getQty());
    }
}
