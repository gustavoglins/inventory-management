package br.com.gustavo.exceptions;

import br.com.gustavo.model.Product;

public class Validate {

    private Validate(){}

    public static void Product(Product product){
        if(product.getName() == null){
            throw new MenuActionException("");
        }
    }
}
