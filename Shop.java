import java.util.*;

public class Shop {
    private Map<Product, Integer> products = new HashMap<>();
    private WareHouse wareHouse;

    public Shop() {
        wareHouse = new WareHouse();
    }
    public Shop(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }


    public void addProduct(Product product) {
        addProduct(product, 1);
    }
    public void addProduct(Product product, Integer quantity) {
        Integer wareHouseQuantity = wareHouse.getProductQuantity(product);

        if (wareHouseQuantity == null || wareHouseQuantity == 0) {
            System.out.println("Don't have " + product.name + " in ware house");
        } else if (wareHouseQuantity >= quantity) {
            products.put(product, quantity);
            wareHouse.removeProduct(product, quantity);
        } else {
            System.out.println("In ware house we have only " + wareHouseQuantity + " " + product.name + " products");
            products.put(product, wareHouseQuantity);
            wareHouse.removeProduct(product);
        }
    }

    public void removeProduct(Product product) {
        removeProduct(product, 1);
    }
    public void removeProduct(Product product, Integer quantity) {
        Integer productQuantity = products.get(product);
        if (productQuantity >= quantity) {
            wareHouse.addProduct(product, quantity);
            products.put(product, productQuantity - quantity);
        } else {
            wareHouse.addProduct(product, productQuantity);
            products.remove(product);
        }
    }

    public Product getProduct(String name) {
        for (Product product : products.keySet()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
    public Map<Product, Integer> getProducts() {
        return products;
    }
    public Integer getProductQuantity(Product product) {
        return products.get(product);
    }
}
