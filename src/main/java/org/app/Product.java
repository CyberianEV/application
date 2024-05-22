package org.app;

public class Product {
    private final String id;
    private final String title;
    private final String cost;

    public Product(String id, String title, String cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCost() {
        return cost;
    }
}
