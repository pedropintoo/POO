package aula09.ex3;

public class CommercialPlane extends Plane {
    private final int numOfCrewMembers;

    public CommercialPlane(String id, String manufacturer, String model, int yearOfManufacture, int maxNumOfPassengers, double maxSpeed, int numOfCrewMembers) {
        super(id, manufacturer, model, yearOfManufacture, maxNumOfPassengers, maxSpeed);
        this.numOfCrewMembers = numOfCrewMembers;
    }

    @Override
    public String toString() {
        return "CommercialPlane{ " +
                super.toString() +
                ", numOfCrewMembers=" + numOfCrewMembers +
                '}';
    }

    @Override
    public String getPlaneType(){
        return "Commercial";
    }
}
