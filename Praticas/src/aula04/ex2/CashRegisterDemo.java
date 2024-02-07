package aula04.ex2;

import utils.UserInput;

import java.util.ArrayList;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int  getQuantity() {
        return quantity;
    }
}


class CashRegister {
    // TODO: completar implementação da classe

    // Array to save products
    private static ArrayList<Product> productsList =  new ArrayList<Product>();

    public void addProduct(Product product){
        productsList.add(product);
    }

    public String toString(){
        // TODO: Listar o conteúdo e valor total

        // Declarations
        String menu;
        double totalPrice = 0;

        // Adding the text to return variable "String menu"
        menu = String.format("%-15s %8s %8s %10s\n", "Product", "Price", "Quantity", "Total");
        // For each product
        for(Product product : productsList){
            menu += String.format("%-15s %8s %8s %10.5s\n",product.getName(), product.getPrice(), product.getQuantity(), product.getTotalValue());
            totalPrice += product.getTotalValue();
        }
        menu += "\nTotal value: " + totalPrice;
        return menu;
    }
}

public class CashRegisterDemo {

    public static void main(String[] args) {

        // Cria e adiciona 5 produtos
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));

        System.out.println(cr);

    }
}