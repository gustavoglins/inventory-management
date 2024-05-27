package br.com.gustavo.service;

import br.com.gustavo.model.InventoryManager;
import br.com.gustavo.model.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ApplicationService {

    final static InventoryManager inventoryManager = new InventoryManager();
    private static final Scanner input = new Scanner(System.in);

    public ApplicationService() {
    }

    public void brand() {
        System.out.println("\n------------------------------------------");
        System.out.println("---------- Inventory Management ----------");
        System.out.println("------------------------------------------\n");
    }

    public void menu() {
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

    public int getAction() {
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

    public void registerProduct() {
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

    public void removeProduct() {
        System.out.println("\n----- Remove product -----");
        System.out.println("Remove by ID or name: ");
        System.out.println("|   1   | - By name");
        System.out.println("|   2   | - By ID");

        int action = getAction();

        if (action == 1) {
            System.out.print("Enter the product name to be removed: ");
            input.nextLine();
            String name = input.nextLine();

            String message = inventoryManager.removeProduct(name);
            System.out.println(message);

        } else if (action == 2) {
            System.out.print("Enter the product id to be removed: ");
            int id = input.nextInt();

            String message = inventoryManager.removeProduct(id);
            System.out.println(message);

        } else {
            System.out.println("Error! Please enter a valid action.");
            removeProduct();
        }
    }

    public void listProducts() {
        System.out.println("\n----- List products -----");

        List<String> productStrings = inventoryManager.listProduct();

        for (String productString : productStrings) {
            System.out.println(productString);
        }

        System.out.println("-------------------------");
    }

    public void searchProduct() {
        System.out.println("\n----- Search product -----");
        System.out.println("Search by ID or name? ");
        System.out.println("|   1   | - By name");
        System.out.println("|   2   | - By ID");

        int action = getAction();

        if (action == 1) {
            System.out.print("Enter the product name: ");
            input.nextLine();
            String name = input.nextLine();

            String message = inventoryManager.searchProduct(name);
            System.out.println(message);

        } else if (action == 2) {
            System.out.print("Enter the product ID: ");
            int id = input.nextInt();

            String message = inventoryManager.searchProduct(id);
            System.out.println(message);

        } else {
            System.out.println("Error! Please enter a valid action.");
            searchProduct();
        }
    }

    public void updateProduct() {
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

    public void updateQuantity() {
        System.out.println("\n----- Update product quantity -----");
        System.out.println("Update quantity by name or ID? ");
        System.out.println("|   1   | - By name");
        System.out.println("|   2   | - By ID");

        int action2 = getAction();

        // By name
        if (action2 == 1) {
            System.out.print("Enter the product name: ");
            input.nextLine();
            String name = input.nextLine();

            boolean signal = inventoryManager.thisProductExit(name);
            if (signal) {
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

                String message = inventoryManager.updateQuantity(action, name, quantity);
                System.out.println(message);
            } else {
                System.out.println("Error! Product not found or not registered.");
            }

            // By ID
        } else if (action2 == 2) {
            System.out.print("Enter the product ID: ");
            //TODO tratar erro!
            int id = input.nextInt();

            boolean signal = inventoryManager.thisProductExit(id);
            if (signal) {
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

                String message = inventoryManager.updateQuantity(action, id, quantity);
                System.out.println(message);
            } else {
                System.out.println("Error! Product not found or not registere.");
            }

            // Invalid action
        } else {
            System.out.println("Error! Please enter a valid option.");
            updateQuantity();
        }
    }

    public void updatePrice() {
        System.out.println("\n----- Update product price -----");
        System.out.println("Update price by name or ID?");
        System.out.println("|   1   | - By name");
        System.out.println("|   2   | - By ID");

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
            System.out.print("Enter the product ID: ");
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

    public void exitProgram() {
        System.out.println("Exiting...");
        input.close();
        System.exit(0);
    }
}
