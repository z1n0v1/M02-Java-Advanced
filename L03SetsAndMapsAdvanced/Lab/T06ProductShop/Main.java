package L03SetsAndMapsAdvanced.Lab.T06ProductShop;

import java.util.*;

public class Main {
    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
        public String toString() {
            return String.format("Product: %s, Price: %.1f", name, price);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<Product>> shops = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] data = input.split(", ");
            if (!shops.containsKey(data[0]))
                shops.put(data[0], new ArrayList<>());

            Product product = new Product(data[1], Double.parseDouble(data[2]) );
            shops.get(data[0]).add(product);

            input = scanner.nextLine();
        }
        shops.forEach((name, products) -> {
            System.out.printf("%s->%n", name);
            products.forEach(System.out::println);
        });
    }
}
