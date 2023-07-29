public class PhysicalProduct extends Product {
    final float weight;

    public PhysicalProduct(String name, float price, float weight) {
        super(name, price);
        this.weight = weight;
    }

    public float getShippingWeight() {
        return weight;
    }
}
