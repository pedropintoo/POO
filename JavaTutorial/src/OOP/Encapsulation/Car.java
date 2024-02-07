package OOP.Encapsulation;

public class Car {
    // Por questão de segurança
    private String make;
    private String model;
    private int year;

    Car(String make, String model, int year){
        this.setMake(make);
        this.setModel(model);
        this.setYear(year);
    }
    public String toString(){
        return make + " " + model + " - " + year + "\n";
    }

    // São métodos para chamar os "private"
    // Serve para segurança, mas complica o código !
            //GET
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
            //SET
    public void setMake(String make){
        this.make = make;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setYear(int year){
        this.year = year;
    }

}
