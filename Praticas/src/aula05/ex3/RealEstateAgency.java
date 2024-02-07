package aula05.ex3;

import aula05.ex1.DateYMD;

import java.util.ArrayList;
import java.util.Date;

public class RealEstateAgency {
    /// Nota: Alguns métodos desta Classe foram aproveitados do primeiro enunciado disponibilizado
    /// e adaptados para corresponderem aos requesitos do 'Main' dado no eLearning alguns dias depois
    /// Por esse motivo existem métodos que não estão a ser utilizados ou não muito necessários

    private final ArrayList<Property> listProperties = new ArrayList<>();

    @Override
    public String toString() {
        String result;

        result = "Properties: \n";
        for(Property property : this.listProperties){
            result += "Property: "+property.getNumericIdentifier()+"; bedrooms: "+property.getNumberOfBedrooms();
            result += "; location: "+property.getLocation()+"; price: "+property.getPrice()+"; availability: ";
            if(property.isAvailable()){
                result += "yes";
            }
            else result += "no";

            // If Property is in auction
            if(property.getDateOfEnd() != null){
                result += "; auction: "+property.getDateOfStart().toStringFormat()+" : "+property.getDateOfEnd().toStringFormat();
            }
            result += "\n";
        }
        return result;
    }

    // Public Methods
    public void newProperty(String location, int numberOfBedrooms, double price){
        // add property to listProperties
        setProperty(new Property(numberOfBedrooms, location, price,true, null, null));
    }
    public void sell(int numericIdentifier){
        int index = -1;
        for(Property property : this.listProperties){
            if(property.getNumericIdentifier() == numericIdentifier && property.isAvailable()){
                index = numericIdentifier - Property.START_IDENTIFIER; // Ex: index = 1012 - 1000 = 12
            }
        }
        if(index == -1){
            System.out.println("Property "+numericIdentifier+" is not for sell!");
        }
        else {
            // set available
            setPropertyAvailableByNumericIdentifier(numericIdentifier, false); // not available anymore
            System.out.println("Property "+numericIdentifier+" is sold!");
        }

    }
    public void setAuction(int numericIdentifier, DateYMD dateOfStart, int timeOfAuction){
        // Declarations
        DateYMD dateOfEnd;

        // verification of index
        if (numericIdentifier - Property.START_IDENTIFIER < 0 || numericIdentifier - Property.START_IDENTIFIER >= this.listProperties.size()){
            System.out.println("Property "+numericIdentifier+" does not exist!");
        }
        else if(isPropertyAvailableByNumericIdentifier(numericIdentifier)){
            // set dateOfStart
            setPropertyDateOfStartByNumericIdentifier(numericIdentifier,dateOfStart);

            // Starting dateOfEnd with start date, for in the future increment and set to the property
            dateOfEnd = new DateYMD(dateOfStart.getDay(),dateOfStart.getMonth(),dateOfStart.getYear());
            dateOfEnd.increment(timeOfAuction);

            // set dateOfEnd
            setPropertyDateOfEndByNumericIdentifier(numericIdentifier,dateOfEnd);
        }
        else{
            System.out.println("Property "+numericIdentifier+" is not available!");
        }
    }

    // Getters
    public ArrayList<Property> getListProperties(){
        return this.listProperties;
    }
    // byNumericIdentifier
    public String getPropertyLocationByNumericIdentifier(int numericIdentifier) {
        return this.listProperties.get(numericIdentifier - Property.START_IDENTIFIER).getLocation();
    }
    public double getPropertyPriceByNumericIdentifier(int numericIdentifier) {
        return this.listProperties.get(numericIdentifier - Property.START_IDENTIFIER).getPrice();
    }
    public boolean isPropertyAvailableByNumericIdentifier(int numericIdentifier) {
        return this.listProperties.get(numericIdentifier - Property.START_IDENTIFIER).isAvailable();
    }
    public DateYMD getPropertyDateOfStartByNumericIdentifier(int numericIdentifier) {
        return this.listProperties.get(numericIdentifier - Property.START_IDENTIFIER).getDateOfStart();
    }
    public DateYMD getPropertyDateOfEndByNumericIdentifier(int numericIdentifier) {
        return this.listProperties.get(numericIdentifier - Property.START_IDENTIFIER).getDateOfEnd();
    }

    // Setters
    public void setProperty(Property property){
        this.listProperties.add(property);
    }
    public void setProperty(ArrayList<Property> listProperty){
        this.listProperties.addAll(listProperty);
    }
    // byNumericIdentifier
    public void setPropertyAvailableByNumericIdentifier(int numericIdentifier, boolean value) {
        this.listProperties.get(numericIdentifier - Property.START_IDENTIFIER).setAvailable(value);
    }
    public void setPropertyDateOfStartByNumericIdentifier(int numericIdentifier, DateYMD dateOfStart) {
        this.listProperties.get(numericIdentifier - Property.START_IDENTIFIER).setDateOfStart(dateOfStart);
    }
    public void setPropertyDateOfEndByNumericIdentifier(int numericIdentifier, DateYMD dateOfEnd) {
        this.listProperties.get(numericIdentifier - Property.START_IDENTIFIER).setDateOfEnd(dateOfEnd);
    }

}
