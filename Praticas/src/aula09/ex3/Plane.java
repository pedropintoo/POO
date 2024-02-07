package aula09.ex3;

import java.util.Objects;

public abstract class Plane {
    private final String id;
    private final String manufacturer;
    private final String model;
    private final int yearOfManufacture;
    private final int maxNumberOfPassengers;
    private final double maxSpeed;

    public Plane(String id, String manufacturer, String model, int yearOfManufacture, int maxNumberOfPassengers, double maxSpeed) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.maxSpeed = maxSpeed;


    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", maxNumberOfPassengers=" + maxNumberOfPassengers +
                ", maxSpeed=" + maxSpeed;
    }


    // Getters

    public String getId() {
        return this.id;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getYearOfManufacture() {
        return this.yearOfManufacture;
    }

    public int getMaxNumberOfPassengers() {
        return this.maxNumberOfPassengers;
    }

    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    public abstract String getPlaneType();
}
