package aula04.ex1;


import java.util.Scanner;

class Circle {
    private double radius;


    Circle(double radius){
        setRadius(radius);
    }


    public boolean equals(Circle circle){
        return getRadius() == circle.getRadius();
    }

    @Override
    public String toString(){
        return String.format("   %-14.1f %-14.1f %-14.1f",getRadius(),getArea(),getPerimeter());
    }

    // Validation
    private static double validateRadius(double radius){
        Scanner sc = new Scanner(System.in);
        while(radius<=0){
            System.out.println("-- Radius must be positive! --");
            System.out.print("Set the Radius: ");
            radius = sc.nextDouble();
        }
        return radius;
    }

    // Getters
    private double getRadius(){
        return this.radius;
    }
    private double getArea(){
        return Math.PI * getRadius() * getRadius();
    }
    private double getPerimeter(){
        return 2 * Math.PI * getRadius() ;
    }


    // Setters
    private void setRadius(double radius){
        this.radius = validateRadius(radius);
    }

}
