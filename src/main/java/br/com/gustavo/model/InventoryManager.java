package br.com.gustavo.model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class InventoryManager {

    private final List<Product> products;

    public InventoryManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
            System.out.println("Product added successfully.");
        } else{
            System.out.println("This product has already been registered.");
        }
    }

    public void removeProduct(Product product) {
        if(products.contains(product)){
            products.remove(product);
            System.out.println("Product removed successfully.");
        } else{
            System.out.println("Product not registered.");
        }
    }

    public void listProduct() {
        System.out.println("----- List product -----");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void searchProduct(String name) {
        System.out.println("----- Search product -----");
        if (!products.isEmpty()) {
            boolean found = false;
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    System.out.println(product);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Product not found or not registered");
            }
        } else {
            System.out.println("No products registered yet.");
        }
    }

    public void searchProduct(int id) {
        System.out.println("----- Search product -----");
        if (!products.isEmpty()) {
            boolean found = false;
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    System.out.println(product);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Product not found or not registered.");
            }
        } else {
            System.out.println("No products registered yet.");
        }
    }

    public void updateStock(int action, String name, int quantity) {
        if (action == 1) {
            boolean found = false;
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    product.setQuantity(product.getQuantity() + quantity);
                    found = true;
                }
            }
            if(!found){
                System.out.println("Error! Product not found or not registered.");
            }
        } else if (action == 2) {
            boolean found = false;
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    product.setQuantity(product.getQuantity() - quantity);
                    found = true;
                }
            }
            if(!found){
                System.out.println("Error! Product not found or not registered.");
            }
        } else{
            System.out.println("Error! Please enter a valid action.");
        }
    }

    public void updateStock(int action, int id, int quantity) {
        if (action == 1) {
            boolean found = false;
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    product.setQuantity(product.getQuantity() + quantity);
                    found = true;
                }
            }
            if(!found){
                System.out.println("Error! Product not found or not registered.");
            }
        } else if (action == 2) {
            boolean found = false;
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    product.setQuantity(product.getQuantity() - quantity);
                    found = true;
                }
            }
            if(!found){
                System.out.println("Error! Product not found or not registered.");
            }
        } else{
            System.out.println("Error! Please enter a valid action.");
        }
    }

    public void updatePrice(String name, double price) {
        if(!products.isEmpty()){
            boolean found = false;
            for(Product product : products){
                if(product.getName().equalsIgnoreCase(name)){
                    product.setPrice(price);
                    found = true;
                }
            }
            if(!found){
                System.out.println("Error! Product not found or not registered.");
            }
        } else{
            System.out.println("No products registered.");
        }
    }
}
