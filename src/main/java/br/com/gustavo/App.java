package br.com.gustavo;

import br.com.gustavo.model.InventoryManager;
import br.com.gustavo.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class App {

    private static final Scanner input = new Scanner(System.in);

    final static InventoryManager inventoryManager = new InventoryManager();
    final Product product = new Product();

    //TODO criar e implementar exceptions personalizadas

    public static void main(String[] args) {
        brand();
        menu();
    }

    private static void brand(){
        System.out.println("\n------------------------------------------");
        System.out.println("---------- Inventory Management ----------");
        System.out.println("------------------------------------------\n");
    }

    private static void menu(){
        System.out.println("What action do you want to perform? ");
        System.out.println("|   1   | - Register a new product.");
        System.out.println("|   2   | - Remove a product");
        System.out.println("|   3   | - List all products");
        System.out.println("|   4   | - Search for a product");
        System.out.println("|   5   | - Update product quantity");
        System.out.println("|   6   | - Update product price");
        System.out.println("|   0   | - Exit");

        int action = getAction();

        switch (action){
            case 1 -> registerProduct();
            case 2 -> removeProduct();
            case 3 -> listProducts();
            case 4 -> searchProduct();
            case 5 -> updateQuantity();
            case 6 -> updatePrice();
            case 0 -> exitProgram();
            default -> System.out.println("Error! Please enter a valid action.");
        }
    }

    private static int getAction(){
        boolean validAction = false;
        int action = -1;
        while(!validAction){
            System.out.print("Action: ");
            try{
                action = input.nextInt();
                validAction = true;
            } catch (InputMismatchException e){
                System.out.println("Error! Please enter a valid integer number.");
                input.next();
            }
        }
        return action;
    }

    private static void registerProduct(){
        System.out.println("----- List product -----");
        System.out.print("Enter the product name: ");
        String name = input.nextLine();
        input.nextLine();
        System.out.print("Enter the product price: ");
        double price = input.nextDouble();
        System.out.print("Enter the amount of products available: ");
        int quantity = input.nextInt();

        inventoryManager.registerProduct(new Product(name, price, quantity));

    }

    private static void removeProduct(){

    }

    private static void listProducts(){

    }

    private static void searchProduct(){

    }

    private static void updateQuantity(){

    }

    private static void updatePrice(){

    }

    private static void exitProgram(){
        System.out.println("Exiting...");
        input.close();
        System.exit(0);
    }
}
