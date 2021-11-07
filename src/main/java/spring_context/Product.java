package spring_context;

public class Product {
    private long id;
    private String title;
    private int cost;


    public Product(long id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public long getId() {
        return id;
    }




}
