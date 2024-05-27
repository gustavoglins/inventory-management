package br.com.gustavo;

import br.com.gustavo.model.InventoryManager;
import br.com.gustavo.model.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
public class App {

    private static final Scanner input = new Scanner(System.in);

    final static InventoryManager inventoryManager = new InventoryManager();
    final Product product = new Product();

    public static void main(String[] args) {
        brand();
        menu();
    }

    private static void brand() {
        System.out.println("\n------------------------------------------");
        System.out.println("---------- Inventory Management ----------");
        System.out.println("------------------------------------------\n");
    }

    private static void menu() {
        System.out.println("\nWhat action do you want to perform? ");
        System.out.println("|   1   | - Register a new product.");
        System.out.println("|   2   | - Remove a product");
        System.out.println("|   3   | - List all products");
        System.out.println("|   4   | - Search for a product");
        System.out.println("|   5   | - Update product");
        System.out.println("|   0   | - Exit");

        int action = getAction();

        switch (action) {
            case 1:
                registerProduct();
                menu();
                break;
            case 2:
                removeProduct();
                menu();
                break;
            case 3:
                listProducts();
                menu();
                break;
            case 4:
                searchProduct();
                menu();
                break;
            case 5:
                updateProduct();
                menu();
                break;
            case 0:
                exitProgram();
                break;
            default:
                System.out.println("Error! Please enter a valid action.");
                menu();
                break;
        }
    }

    private static int getAction() {
        boolean validAction = false;
        int action = -1;
        while (!validAction) {
            System.out.print("Action: ");
            try {
                action = input.nextInt();
                validAction = true;
            } catch (InputMismatchException e) {
                System.out.println("Error! Please enter a valid integer number.");
                input.next();
            }
        }
        return action;
    }

    private static void registerProduct() {
        System.out.println("\n----- Register product -----");
        System.out.print("Enter the product name: ");
        input.nextLine();
        String name = input.nextLine();

        System.out.print("Enter the product price: ");
        double price = input.nextDouble();

        System.out.print("Enter the amount of products available: ");
        int quantity = input.nextInt();

        String message = inventoryManager.registerProduct(new Product(name, price, quantity));
        System.out.println(message);
    }

    private static void removeProduct() {
        System.out.println("\n----- Remove product -----");
        System.out.print("Enter the product name to be removed: ");
        input.nextLine();
        String name = input.nextLine();

        String message = inventoryManager.removeProduct(name);
        System.out.println(message);
    }

    private static void listProducts() {
        System.out.println("\n----- List products -----");

        List<String> productStrings = inventoryManager.listProduct();

        for (String productString : productStrings) {
            System.out.println(productString);
        }
    }

    private static void searchProduct() {
        System.out.println("\n----- Search product -----");
        System.out.print("Search by id or name? ");

        String action = input.next().trim();

        if (action.equalsIgnoreCase("name")) {
            System.out.print("Enter the product name: ");
            input.nextLine();
            String name = input.nextLine();

            String message = inventoryManager.searchProduct(name);
            System.out.println(message);

        } else if (action.equalsIgnoreCase("id")) {
            System.out.print("Enter the product id: ");
            int id = input.nextInt();

            String message = inventoryManager.searchProduct(id);
            System.out.println(message);
        }
    }

    private static void updateProduct() {
        System.out.println("\n----- Update product -----");
        System.out.println("Do you want to update the price or quantity of a product");
        System.out.println("|   1   | - Update quantity");
        System.out.println("|   2   | - Update price");

        int action = getAction();

        switch (action) {
            case 1:
                updateQuantity();
                break;
            case 2:
                updatePrice();
                break;
            default:
                System.out.println("Error! Please enter a valid action.");
                updateProduct();
                break;
        }
    }

    private static void updateQuantity() {
        System.out.println("\n----- Update product quantity -----");
        System.out.println("Update quantity by name or id? ");
        System.out.println("|   1   | - By name");
        System.out.println("|   2   | - By id");

        int action2 = getAction();

        if (action2 == 1) {
            System.out.print("Enter the product name: ");
            input.nextLine();
            String name = input.nextLine();

            System.out.println("\nProduct selected: ");
            inventoryManager.searchProduct(name);

            System.out.println("\nDo you want to increase or decrease the product quantity? ");
            System.out.println("|   1   | - Increase");
            System.out.println("|   2   | - Decrease");

            int action = getAction();

            int quantity = 0;
            if (action == 1) {
                System.out.print("Enter the quantity for increase: ");
                quantity = input.nextInt();

            } else if (action == 2) {
                System.out.print("Enter the quantity for decrease: ");
                quantity = input.nextInt();
            }

            inventoryManager.updateQuantity(action, name, quantity);

        } else if (action2 == 2) {
            System.out.print("Enter the product id: ");
            int id = input.nextInt();

            System.out.println("\nProduct selected: ");
            inventoryManager.searchProduct(id);

            System.out.println("\nDo you want to increase or decrease the product quantity? ");
            System.out.println("|   1   | - Increase");
            System.out.println("|   2   | - Decrease");

            int action = getAction();

            int quantity = 0;
            if (action == 1) {
                System.out.print("Enter the quantity for increase: ");
                quantity = input.nextInt();

            } else if (action == 2) {
                System.out.print("Enter the quantity for decrease: ");
                quantity = input.nextInt();
            }

            inventoryManager.updateQuantity(action, id, quantity);

        } else {
            System.out.println("Error! Please enter a valid option.");
            updateQuantity();
        }
    }

    private static void updatePrice() {
        System.out.println("\n----- Update product price -----");
        System.out.println("Update price by name or id?");
        System.out.println("|   1   | - By name");
        System.out.println("|   2   | - By id");

        int action = getAction();

        if (action == 1) {
            System.out.print("Enter the product name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.println("\nProduct selected: ");
            inventoryManager.searchProduct(name);
            System.out.print("\nEnter the product new price: US$");
            double price = input.nextDouble();
            String message = inventoryManager.updatePrice(name, price);
            System.out.println(message);

        } else if (action == 2) {
            System.out.print("Enter the product id: ");
            int id = input.nextInt();
            System.out.println("\nProduct selected: ");
            inventoryManager.searchProduct(id);
            System.out.print("\nEnter the product new price: US$");
            double price = input.nextDouble();
            String message = inventoryManager.updatePrice(id, price);
            System.out.println(message);

        } else {
            System.out.println("Error! enter a valid option.");
            updatePrice();
        }
    }

    private static void exitProgram() {
        System.out.println("Exiting...");
        input.close();
        System.exit(0);
    }
}
