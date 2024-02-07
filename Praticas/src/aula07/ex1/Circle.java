package aula07.ex1;


import java.util.Scanner;

class Circle extends Form {
    private double radius;


    Circle(double radius, String color){
        super(color);
        setRadius(radius);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Circle other = (Circle) obj;
        // verify if the object’s attributes are equals
        if (getRadius() != other.getRadius())
            return false;
        if (!getColor().equals(other.getColor()))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return String.format("   %-14.1f %-14.1f %-14.1f %-14s",getRadius(),getArea(),getPerimeter(),getColor());
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
    public double getArea(){
        return Math.PI * getRadius() * getRadius();
    }
    public double getPerimeter(){
        return 2 * Math.PI * getRadius() ;
    }


    // Setters
    private void setRadius(double radius){
        this.radius = validateRadius(radius);
    }

}
