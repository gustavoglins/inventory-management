package br.com.gustavo.model;

import br.com.gustavo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class StockReportGenerator {


    public StockReportGenerator() {
    }

    public static String generateReport(List<Product> products) {
        final StringBuilder report = new StringBuilder();

        final int LOW_QUANTITY_THRESHOLD = 20;
        final int IDEAL_QUANTITY_THRESHOLD = 50;

        final List<Product> productsLowQuantity = new ArrayList<>();
        final List<Product> productsIdealQuantity = new ArrayList<>();
        final List<Product> productsHighQuantity = new ArrayList<>();
        final List<Product> bestSellingProducts = new ArrayList<>();
        final List<Product> highestValueProducts = new ArrayList<>();

        double stockTotalValue = 0.0;

        // Get product quantity status
        for (Product product : products) {

            // Get low quantity products
            if (product.getQuantity() <= LOW_QUANTITY_THRESHOLD) {
                productsLowQuantity.add(product);

                // Get ideal quantity products
            } else if (product.getQuantity() > LOW_QUANTITY_THRESHOLD && product.getQuantity() <= IDEAL_QUANTITY_THRESHOLD) {
                productsIdealQuantity.add(product);

                // Get high quantity products
            } else if (product.getQuantity() > IDEAL_QUANTITY_THRESHOLD) {
                productsHighQuantity.add(product);
            }
        }

        // Get stock total value
        for (Product product : products) {
            stockTotalValue += product.getPrice() * product.getQuantity();
        }

        report.append("\n----- INVENTORY REPORTS ------\n");

        report.append("\n-- Products with low stock --\n");
        for (Product product : productsLowQuantity) {
            report.append(product);
            report.append("\n");
        }

        report.append("\n- Products with ideal stock --\n");
        for (Product product : productsIdealQuantity) {
            report.append(product);
            report.append("\n");
        }

        report.append("\n- Products with high stock --\n");
        for (Product product : productsHighQuantity) {
            report.append(product);
            report.append("\n");
        }

        report.append("\n-- Total stock value --\n");
        report.append("US$");
        double value = stockTotalValue;
        Utils utils = new Utils();
        report.append(utils.formatValue(value));

        return report.toString();
    }

}
