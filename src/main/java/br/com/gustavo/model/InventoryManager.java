package br.com.gustavo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unused")
public class InventoryManager {

    private final List<Product> products;

    public InventoryManager() {
        this.products = new ArrayList<>();
    }

    public String registerProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
            return "Product registered successfully.";
        } else {
            return "This product has already been registered.";
        }
    }

    public String removeProduct(String name) {
        boolean found = false;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                found = true;
            }
        }
        if (found) {
            return "Product removed successfully";
        } else {
            return "Product not registered";
        }
    }

    public List<String> listProduct() {
        List<String> productString = new ArrayList<>();
        for (Product product : products) {
            productString.add(product.toString());
        }
        return productString;
    }

    public String searchProduct(String name) {
        boolean found = false;
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    System.out.println(product);
                    found = true;
                }
            }
            if (!found) {
                return "Product not found or not registered";
            }
        } else {
            return "No products registered yet.";
        }
        return null;
    }

    public String searchProduct(int id) {
        boolean found = false;
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    System.out.println(product);
                    found = true;
                }
            }
            if (!found) {
                return "Product not found or not registered.";
            }
        } else {
            return "No products registered yet.";
        }
        return null;
    }

    //TODO
    public String updateQuantity(int action, String name, int quantity) {
        if (action == 1) {
            boolean found = false;
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    product.setQuantity(product.getQuantity() + quantity);
                    found = true;
                }
            }
            if (!found) {
                return "Error! Product not found or not registered.";
            }
        } else if (action == 2) {
            boolean found = false;
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    product.setQuantity(product.getQuantity() - quantity);
                    found = true;
                }
            }
            if (!found) {
                return "Error! Product not found or not registered.";
            }
        } else {
            return "Error! Please enter a valid action.";
        }
        return "Unexpected error! Please try again in a few minutes.";
    }

    public String updateQuantity(int action, int id, int quantity) {
        if (action == 1) {
            boolean found = false;
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    product.setQuantity(product.getQuantity() + quantity);
                    found = true;
                }
            }
            if (!found) {
                return "Error! Product not found or not registered.";
            }
        } else if (action == 2) {
            boolean found = false;
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    product.setQuantity(product.getQuantity() - quantity);
                    found = true;
                }
            }
            if (!found) {
                return "Error! Product not found or not registered.";
            }
        } else {
            return "Error! Please enter a valid action.";
        }
        return "Unexpected error! Please try again in a few minutes.";
    }

    public String updatePrice(String name, double price) {
        boolean found = false;
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    product.setPrice(price);
                    found = true;
                }
            }
        } else {
            return "No products registered.";
        }
        if (found) {
            return "Price updated successfully.";
        } else {
            return "Error! Product not found or not registered.";
        }
    }

    public String updatePrice(int id, double price) {
        boolean found = false;
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    product.setPrice(price);
                    found = true;
                }
            }
        } else {
            return "No products registered.";
        }
        if (found) {
            return "Price updated successfully.";
        } else {
            return "Error! Product not found or not registered.";
        }
    }
}
