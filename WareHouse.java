import java.util.*;

public class WareHouse {
    private Map<Product, Integer> productCount;

    public WareHouse() {
        productCount = new HashMap<>();
    }
    public WareHouse(Map<Product, Integer> productCount) {
        this.productCount = productCount;
    }


    public Map<Product, Integer> getProducts(){
        return productCount;
    }

    public void addProduct(Product product) {
        addProduct(product, 1);
    }
    public void addProduct(Product product, Integer quantity) {
        if (productCount.containsKey(product)) {
            productCount.put(product, quantity + productCount.get(product));
        } else {
            productCount.put(product, quantity);
        }
    }

    public void removeProduct(Product product) {
        productCount.remove(product);
    }
    public void removeProduct(Product product, Integer quantity) {
        if (productCount.get(product) >= quantity) {
            productCount.put(product, productCount.get(product) - quantity);
        } else {
            removeProduct(product);
        }
    }

    public Integer getProductQuantity(Product product) {
        return productCount.get(product);
    }
}
