package OOP.Super;

public class Hero extends Person{
    String power;
    Hero(String name, int age, String power){
        super(name,age); // "super" refere-se a Person
        this.power = power;
    }
    public String toString(){
        return super.toString() + this.power;
    }
}
