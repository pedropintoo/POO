package aula04.ex1;

import java.util.Scanner;

class Rectangle {
    private double width, height;

    Rectangle(double width, double height){
        setDimensions(width, height);
    }

    public boolean equals(Rectangle rectangle){
        return (getWidth() == rectangle.getWidth() && getHeight() == rectangle.getHeight());
    }

    @Override
    public String toString(){
        return String.format("   %-14.1f %-14.1f %-14.1f %-14.1f",getWidth(),getHeight(),getArea(),getPerimeter());
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
    private double getArea(){
        return getHeight() * getWidth();
    }
    private double getPerimeter(){
        return getHeight()*2 + getWidth()*2;
    }


    // Setters
    private void setDimensions(double width, double height) {
        this.width = validateDimension(width, "Width");
        this.height = validateDimension(height, "Height");
    }
}
