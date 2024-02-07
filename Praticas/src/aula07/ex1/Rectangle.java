package aula07.ex1;

import java.util.Scanner;

class Rectangle extends Form {
    private double width, height;

    Rectangle(double width, double height, String color){
        super(color);
        setDimensions(width, height);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rectangle other = (Rectangle) obj;
        // verify if the object’s attributes are equals
        if (getWidth() != other.getWidth())
            return false;
        if (getHeight() != other.getHeight())
            return false;
        if (!getColor().equals(other.getColor()))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return String.format("   %-14.1f %-14.1f %-14.1f %-14.1f %-14s",getWidth(),getHeight(),getArea(),getPerimeter(),getColor());
    }


    // Validation
    private static double validateDimension(double dimension, String name){
        Scanner sc = new Scanner(System.in);
        while(dimension<=0){
            System.out.printf("-- %s must be positive! --\n",name);
            System.out.printf("Set the %s: ",name);
            dimension = sc.nextDouble();
        }
        return dimension;
    }

    // Getters
    private double getWidth(){
        return this.width;
    }
    private double getHeight(){
        return this.height;
    }
    public double getArea(){
        return getHeight() * getWidth();
    }
    public double getPerimeter(){
        return getHeight()*2 + getWidth()*2;
    }


    // Setters
    private void setDimensions(double width, double height) {
        this.width = validateDimension(width, "Width");
        this.height = validateDimension(height, "Height");
    }
}
