package br.com.gustavo.model;

@SuppressWarnings("unused")
public class Product {

    private Integer id = 0;
    private String name;
    private Double price;
    private Integer quantity;

    public Product(Integer id, String name, Double price, Integer quantity) {
        this.id += 1;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "\nID: " + getId() +
                "\nName: " + getName() +
                "\nPrice: " + getPrice() +
                "\nQuantity: " + getQuantity();
    }
}
