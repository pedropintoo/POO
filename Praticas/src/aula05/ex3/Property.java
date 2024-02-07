package aula05.ex3;

import aula05.ex1.DateYMD;

public class Property {

    // Public + Static + Final
    public static final int START_IDENTIFIER = 1000;
    // Private + Static
    private static int counterIdentifier = 1000;
    // Private + Final
    private final int numericIdentifier, numberOfBedrooms;
    private final double price;
    private final String location;
    // Private
    private boolean available;
    private DateYMD dateOfStart;
    private DateYMD dateOfEnd;


    Property(int numberOfBedrooms, String location, double price, boolean available, DateYMD dateOfStart, DateYMD dateOfEnd ){
        this.numberOfBedrooms = numberOfBedrooms;
        this.location = location;
        this.price = price;
        this.available = available;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;

        this.numericIdentifier = Property.counterIdentifier;
        Property.counterIdentifier += 1;
    }


    // Getters
    public int getNumberOfBedrooms() {
        return this.numberOfBedrooms;
    }
    public int getNumericIdentifier() {
        return this.numericIdentifier;
    }
    public double getPrice() {
        return this.price;
    }
    public String getLocation() {
        return this.location;
    }
    public boolean isAvailable() {
        return this.available;
    }
    public DateYMD getDateOfStart() {
        return this.dateOfStart;
    }
    public DateYMD getDateOfEnd() {
        return this.dateOfEnd;
    }

    // Setters
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void setDateOfStart(DateYMD dateOfStart) {
        this.dateOfStart = dateOfStart;
    }
    public void setDateOfEnd(DateYMD dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }
}
