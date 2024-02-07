package test;

public class SubCarro extends Carro{

    public static void cao(){
        System.out.println("dasdad");
    }

    @Override
    public String toString() {
        return "SubCarro{}";
    }

    @Override
    public void ola() {
        System.out.println("Ola derivada");
    }

}
