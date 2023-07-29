import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> products;
    private Shop shop;
    private float money;

    public ShoppingCart(Shop shop, float money) {
        this.shop = shop;
        this.money = money;
        products = new HashMap<>();
    }


    public void addProduct(Product product) {
        if (shop.getProductQuantity(product) > 0) {
            products.put(product, 1);
        } else {
            System.out.println("This product is not available in the store");
        }
    }
    public void addProduct(Product product, Integer quantity){
        Integer productQuantityInShop = shop.getProductQuantity(product);
        if (productQuantityInShop >= quantity) {
            products.put(product, quantity);
        } else if (productQuantityInShop > 0) {
            System.out.println("There are only " + productQuantityInShop + " " + product.name + " in the shop");
            products.put(product, productQuantityInShop);
        } else {
            System.out.println("This product is not available in the store");
        }
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
    public void removeProduct(Product product, Integer quantity) {
        Integer productQuantity = products.get(product);

        if (productQuantity > quantity) {
            products.put(product, productQuantity - quantity);
        } else {
            products.remove(product);
        }
    }
    public void removeAllProducts() {
        products = new HashMap<>();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
    public Shop getShop() {
        return shop;
    }
    public float getMoney() {
        return money;
    }

    public void pay(float money) {
        this.money -= money;
    }

    public float getTotalPrice() {
        float sum = 0F;

        for (Product product : products.keySet()) {
            sum += product.getPrice();
        }
        return sum;
    }
}
