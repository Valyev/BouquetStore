package com.bouquetstore.Accessories;

abstract class Accessory {
    private final double price;
    private final String name;
    public Accessory(double price,String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return "Name: " + this.getName() + ", Price: "+this.getPrice();
    }

}
