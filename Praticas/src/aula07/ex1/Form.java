package aula07.ex1;

public abstract class Form {
    String color;

    Form(String color){
        this.color = color;
    }

    String getColor(){
        return this.color;
    }
    abstract double getArea();
    abstract double getPerimeter();


}
