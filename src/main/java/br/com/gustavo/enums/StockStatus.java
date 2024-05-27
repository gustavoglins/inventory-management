package br.com.gustavo.enums;

public enum StockStatus {

    LOW_QUANTITY("Low quantity"),
    IDEAL_QUANTITY("Ideal quantity"),
    HIGH_QUANTITY("High quantity");

    private final String description;

    StockStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
