package br.com.gustavo.model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class InventoryManager {

    List<Product> products;

    public InventoryManager(List<Product> products) {
        this.products = new ArrayList<>();
    }

    public Product searchProductByName(String name){
        if(!products.isEmpty()){
            for(Product product : products){
                if(product.getName().equalsIgnoreCase(name)){
                    return product;
                } else{
                    System.out.println("Product not found or non-existing.");
                }
            }
        } else{
            System.out.println("No products registered yet.");
        }
        return null;
    }

    public Product searchProductById(Integer id){
        if(!products.isEmpty()){
            for(Product product : products){
                if(product.getId().equals(id)){
                    return product;
                } else{
                    System.out.println("Product not found or non-existing.");
                }
            }
        } else{
            System.out.println("No products registered yet.");
        }
        return null;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        if(!products.isEmpty()){
            products.remove(product);
        } else{
            System.out.println("No products registered yet.");
        }
    }
}
