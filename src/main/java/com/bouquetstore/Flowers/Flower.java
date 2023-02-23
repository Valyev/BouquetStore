package com.bouquetstore.Flowers;

public class Flower {
    private final String name;
    private final double price;
    private final double freshness;
    private final double stem_length;

    public Flower(String name, double price, double freshness, double stem_lenght) {
        this.name = name;
        this.price = price;
        this.freshness = freshness;
        this.stem_length = stem_lenght;
    }
    @Override
    public String toString() {
        return "Name: " + this.getName() + ", Freshness: " + this.getFreshness()+"%"+", Stem length: "+this.getStem_length()+", Price: "+this.getPrice();
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getFreshness() {
        return freshness;
    }

    public double getStem_length() {
        return stem_length;
    }


}
