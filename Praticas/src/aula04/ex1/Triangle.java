package aula04.ex1;

import java.util.Scanner;

class Triangle {
    private double side1, side2, side3;

    Triangle(double side1, double side2, double side3){
        setSides(side1, side2, side3);
    }


    public boolean equals(Triangle triangle){
        return (getSides(1) == triangle.getSides(1) && getSides(2) == triangle.getSides(2) && getSides(3) == triangle.getSides(3));
    }

    @Override
    public String toString(){
        return String.format("   %-14.1f %-14.1f %-14.1f %-14.1f %-14.1f",getSides(1),getSides(2),getSides(3),getArea(),getPerimeter());
    }

    // Validation
    private static double[] validateSides(double side1, double side2, double side3){
        Scanner sc = new Scanner(System.in);
        // Triangle inequality
        while(side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2){
            System.out.println("-- Triangle must exist! --");
            System.out.print("Set the Side 1: ");
            side1 = sc.nextDouble();
            System.out.print("Set the Side 2: ");
            side2 = sc.nextDouble();
            System.out.print("Set the Side 3: ");
            side3 = sc.nextDouble();
        }
        return new double[] {side1, side2, side3};
    }

    // Getters
    private double[] getSides(){
        return new double[] {this.side1,this.side2,this.side3};
    }
    private double getSides(int index){
        return getSides()[index-1];
    }
    private double getArea(){
        double[] sides = getSides();
        double p = sides[0]/2 + sides[1]/2 + sides[2]/2;
        // Heron's formula
        return Math.sqrt(p*(p-sides[0])*(p-sides[1])*(p-sides[2]));
    }
    private double getPerimeter(){
        return getSides(1) + getSides(2) + getSides(3) ;
    }

    // Setters
    private void setSides(double side1, double side2, double side3 ) {
        double[] sides = validateSides(side1, side2, side3);
        this.side1 = sides[0];
        this.side2 = sides[1];
        this.side3 = sides[2];
    }


}
