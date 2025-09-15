package main;

public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;


    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }


    public String toCSV() {
        return name + "," + description + "," + ID + "," + cost;
    }


    public String toJSON() {
        return String.format("{\"name\":\"%s\",\"description\":\"%s\",\"ID\":\"%s\",\"cost\":%s}",
                name, description, ID, cost);
    }


    public String toXML() {
        return "<main.Product>\n" +
                "  <name>" + name + "</name>\n" +
                "  <description>" + description + "</description>\n" +
                "  <ID>" + ID + "</ID>\n" +
                "  <cost>" + cost + "</cost>\n" +
                "</main.Product>";
    }
}