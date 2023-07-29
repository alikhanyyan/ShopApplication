import java.util.HashMap;
import java.util.Map;

public class Customer {
    private ShoppingCart shoppingCart;

    public ShoppingCart purchase(Shop shop, float money) {
        shoppingCart = new ShoppingCart(shop, money);

        return shoppingCart;
    }

    public void addProductToCart(Product product) {
        try {
            validation();
        } catch (ShoppingCartException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        shoppingCart.addProduct(product);
    }
    public void addProductToCart(Product product, Integer quantity) {
        try {
            validation();
        } catch (ShoppingCartException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        shoppingCart.addProduct(product, quantity);
    }

    public void removeProductFromCart(Product product) {
        try {
            validation();
        } catch (ShoppingCartException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        shoppingCart.removeProduct(product);
    }
    public void removeProductFromCart(Product product, Integer quantity) {
        try {
            validation();
        } catch (ShoppingCartException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        shoppingCart.removeProduct(product, quantity);
    }

    public Map<Product, Integer> getProducts() {
        try {
            validation();
        } catch (ShoppingCartException ex) {
            System.out.println(ex.getMessage());
            return new HashMap<>();
        }

        return shoppingCart.getProducts();
    }
    public void buyProducts() {
        try {
            validation();
        } catch (ShoppingCartException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        float totalPrice = shoppingCart.getTotalPrice();

        if (totalPrice > shoppingCart.getMoney()) {
            System.out.println("Not enough money");
        } else {
            Shop shop = shoppingCart.getShop();
            for (Map.Entry<Product, Integer> product : shoppingCart.getProducts().entrySet()) {
                shop.removeProduct(product.getKey(), product.getValue());
            }

            shoppingCart.pay(totalPrice);
            shoppingCart.removeAllProducts();

            System.out.println("Success!");
        }
    }

    private void validation() {
        if (shoppingCart == null) {
            throw new ShoppingCartException("Add shopping cart");
        }
    }
}
