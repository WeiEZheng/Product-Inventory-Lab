package models;

public class Sneaker {
    private int id;
    private String name;
    private String brand;
    private String sport;
    private double size;
    private int qty;
    private double price;

    public Sneaker(){}

    public Sneaker(int id, String name, String brand, String sport, double size, int qty, double price) {
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.sport=sport;
        this.size=size;
        this.qty=qty;
        this.price=price;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
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

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
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
                "Product sport specification: %s," +
                "Product size: %.2f,"+
                "Product price: %.2f," +
                "Product quantity: %d}",
                getId(),getName(),getBrand(),getSport(),getSize(),getPrice(),getQty());
    }
}
