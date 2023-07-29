public abstract class Product {
    final String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
    public void changePrice(float price) {
        this.price = price;
    }
}
