package aula07.ex1;

import utils.UserInput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // Declarations
        int option;
        ArrayList<Circle> circles = new ArrayList<>();
        ArrayList<Triangle> triangles = new ArrayList<>();
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        do {

            option = UserInput.IntegerInput(1,4, """
                    
                    -- Menu figures --
                    [1] - Create
                    [2] - List
                    [3] - Compare
                    [4] - Exit
                    Option:\s""");
            if(option == 1) createFig(circles, triangles, rectangles );
            else if(option == 2) listFig(circles, triangles, rectangles);
            else if(option == 3) compareFig(circles, triangles, rectangles);

        } while(option != 4);
        sc.close();

    }

    private static void createFig(ArrayList<Circle> circles, ArrayList<Triangle> triangles, ArrayList<Rectangle> rectangles){
        int option;

        do {
            option = UserInput.IntegerInput(1,4, """
                    
                    -- Create figures --
                    [1] - Circle
                    [2] - Triangle
                    [3] - Rectangle
                    [4] - Go Back
                    Option:\s""");
            if(option == 1) createCircle(circles);
            else if(option == 2) createTriangle(triangles);
            else if(option == 3) createRectangle(rectangles);

        } while(option != 4);
    }

    private static void listFig(ArrayList<Circle> circles, ArrayList<Triangle> triangles, ArrayList<Rectangle> rectangles){
        // TODO: list the figs in a table

        // Printing the figures with format
        for(int i = 0; i<circles.size(); i++){
            if(i==0) System.out.printf("\n-- Circles --\n      %-14s %-14s %-14s %-14s\n","Radius","Area","Perimeter","Color");
            System.out.printf("[%d]",i);
            System.out.println(circles.get(i));
        }
        for(int i = 0; i<triangles.size(); i++){
            if(i==0) System.out.printf("\n-- Triangles --\n      %-14s %-14s %-14s %-14s %-14s %-14s\n","Side 1","Side 2","Side 3","Area","Perimeter","Color");
            System.out.printf("[%d]",i);
            System.out.println(triangles.get(i));
        }
        for(int i = 0; i<rectangles.size(); i++){
            if(i==0) System.out.printf("\n-- Rectangles --\n      %-14s %-14s %-14s %-14s %-14s\n","Width","Height","Area","Perimeter","Color");
            System.out.printf("[%d]",i);
            System.out.println(rectangles.get(i));
        }
    }

    private static void compareFig(ArrayList<Circle> circles, ArrayList<Triangle> triangles, ArrayList<Rectangle> rectangles){
        String input;
        String[] indexes;
        int index1, index2;
        Scanner sc2 = new Scanner(System.in); // Because of error in sc2.nextLine()

        System.out.println("\n-- Compare figures --");

        // For each input
        do{
            // Input
            System.out.print("\nCompare two figures in format \"type:index1,index2\": ");
            input = sc2.nextLine();

            // Check input
            if(input.matches("^\\w+:\\d+,\\d+$")) {
                // Split the input and get the indexes
                indexes = input.split(":")[1].split(",");
                index1 = Integer.parseInt(indexes[0]);
                index2 = Integer.parseInt(indexes[1]);

                // Filter by Type
                if ( input.split(":")[0].equalsIgnoreCase("circle")){
                    // For circles

                    if (index1 >= circles.size() || index2 >= circles.size()) {
                        System.out.println("Input not valid. Try Again");
                        continue;
                    }

                    if (circles.get(index1).equals(circles.get(index2))) {
                        System.out.println("The circles are equals!");
                    } else System.out.println("The circles are not equals!");
                }
                else if( input.split(":")[0].equalsIgnoreCase("rectangle")){
                    // For rectangles

                    if (index1 >= rectangles.size() || index2 >= rectangles.size()) {
                        System.out.println("Input not valid. Try Again");
                        continue;
                    }

                    if (rectangles.get(index1).equals(rectangles.get(index2))) {
                        System.out.println("The rectangles are equals!");
                    } else System.out.println("The rectangles are not equals!");
                }
                else if( input.split(":")[0].equalsIgnoreCase("triangle")){
                    // For triangles

                    if (index1 >= triangles.size() || index2 >= triangles.size()) {
                        System.out.println("Input not valid. Try Again");
                        continue;
                    }

                    if (triangles.get(index1).equals(triangles.get(index2))) {
                        System.out.println("The triangles are equals!");
                    } else System.out.println("The triangles are not equals!");
                }
                else {
                    // Any type allowed
                    System.out.println("Type is invalid [circle, rectangle, triangle]. Try Again");
                }
            }
            else if (!input.equals("")){
                System.out.println("Input not valid. Try Again");
            }

        }while(!input.equals(""));
    }

    public static void createCircle(ArrayList<Circle> circles){
        double radius;
        String color;

        System.out.println("\n--- Create Circle ---");

        System.out.print("Set the Radius: ");
        radius = sc.nextDouble();

        System.out.print("Set the Color: ");
        color = sc.next();

        Circle circle = new Circle(radius, color);
        System.out.println("Circle has been created successfully!");

        circles.add(circle);
    }

    public static void createTriangle(ArrayList<Triangle> triangles){
        double side1, side2, side3;
        String color;

        System.out.println("\n--- Create Triangle ---\n");

        System.out.print("Set the Side 1: ");
        side1 = sc.nextDouble();
        System.out.print("Set the Side 2: ");
        side2 = sc.nextDouble();
        System.out.print("Set the Side 3: ");
        side3 = sc.nextDouble();

        System.out.print("Set the Color: ");
        color = sc.next();

        Triangle triangle = new Triangle(side1, side2, side3, color);

        triangles.add(triangle);

        System.out.println("Triangle has been created successfully!");

    }

    public static void createRectangle(ArrayList<Rectangle> rectangles){
        double width, height;
        String color;

        System.out.println("\n--- Create Rectangle ---\n");

        System.out.print("Set the Width: ");
        width = sc.nextDouble();
        System.out.print("Set the Height: ");
        height = sc.nextDouble();

        System.out.print("Set the Color: ");
        color = sc.next();

        Rectangle rectangle = new Rectangle(width, height, color);

        rectangles.add(rectangle);

        System.out.println("Rectangle has been created successfully!");

    }
}
