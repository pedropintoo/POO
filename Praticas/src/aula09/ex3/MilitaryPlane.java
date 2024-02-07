package aula09.ex3;

public class MilitaryPlane extends Plane {
    private final int numMissiles;

    public MilitaryPlane(String id, String manufacturer, String model, int yearOfManufacture, int maxNumOfPassengers, double maxSpeed, int numMissiles) {
        super(id, manufacturer, model, yearOfManufacture, maxNumOfPassengers, maxSpeed);
        this.numMissiles = numMissiles;
    }

    @Override
    public String toString() {
        return "MilitaryPlane{ " +
                super.toString() +
                " numMissiles=" + numMissiles +
                '}';
    }

    @Override
    public String getPlaneType(){
        return "Commercial";
    }
}