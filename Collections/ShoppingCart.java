import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        CartManager cartManager = new CartManager();

        cartManager.addItem("Apple", 1.50);
        cartManager.addItem("Banana", 0.80);
        cartManager.addItem("Orange", 1.20);
        cartManager.addItem("Grapes", 2.00);

        System.out.println("Items in the order added: " + cartManager.getItemsInOrder());
        System.out.println("Items sorted by product name: " + cartManager.getItemsSortedByName());
        System.out.println("Items sorted by price: " + cartManager.getItemsSortedByPrice());
    }
}

class CartManager {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Double> itemsInOrder = new LinkedHashMap<>();
    private Map<String, Double> itemsSortedByPrice = new TreeMap<>();

    public void addItem(String product, double price) {
        productPrices.put(product, price);
        itemsInOrder.put(product, price);
        itemsSortedByPrice.put(product, price);
    }

    public Map<String, Double> getItemsInOrder() {
        return itemsInOrder;
    }

    public Map<String, Double> getItemsSortedByName() {
        return itemsSortedByPrice;
    }

    public Map<String, Double> getItemsSortedByPrice() {
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(productPrices.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());

        Map<String, Double> sortedByPrice = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : sortedList) {
            sortedByPrice.put(entry.getKey(), entry.getValue());
        }

        return sortedByPrice;
    }
}
