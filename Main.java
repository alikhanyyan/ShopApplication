import java.util.Map;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        Product pc = new PhysicalProduct("PC", 5000, 1000);
        Product notebook = new PhysicalProduct("Notebook", 4000, 500);
        Product memory = new DigitalProduct("Memory", 500, 1000);
        memory.changePrice(400);

        WareHouse wareHouse = new WareHouse();
        wareHouse.addProduct(pc, 5);
        wareHouse.addProduct(notebook, 10);
        wareHouse.addProduct(memory, 7);

        Shop shop = new Shop(wareHouse);
        shop.addProduct(pc);
        shop.addProduct(notebook, 3);
        shop.addProduct(memory, 10);
        for (Map.Entry<Product, Integer> product : shop.getProducts().entrySet()) {
            System.out.println(product.getKey().getName() + ": " + product.getValue());
        }
        System.out.println();
        shop.removeProduct(memory, 2);

        for (var product : shop.getProducts().entrySet()) {
            System.out.println(product.getKey().getName() + ": " + product.getValue());
        }
        System.out.println();

        Customer customer = new Customer();
        Map<Product, Integer> products = customer.getProducts();
        customer.addProductToCart(notebook);
        customer.purchase(shop, 7000);
        customer.addProductToCart(pc, 5);
        customer.addProductToCart(memory, 4);
        customer.removeProductFromCart(memory, 2);
        products = customer.getProducts();
        for (Product product : products.keySet()) {
            System.out.println(product.getName() + ": " + products.get(product));
        }
        System.out.println();

        customer.buyProducts();
        products = customer.getProducts();
        for (Product product : products.keySet()) {
            System.out.println(product.getName() + ": " + products.get(product));
        }
        System.out.println();

        for (Map.Entry<Product, Integer> product : shop.getProducts().entrySet()) {
            System.out.println(product.getKey().getName() + ": " + product.getValue());
        }
    }
}