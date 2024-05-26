package br.com.gustavo.exceptions;

@SuppressWarnings({"unused"})
public class MenuActionException extends RuntimeException{

    final private String attributeName;

    public MenuActionException(String attributeName){
        this.attributeName = attributeName;
    }

    public String getMessage(){
        return  String.format("The attribute %s is out of range", attributeName);
    }
}
