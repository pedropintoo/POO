package aula06.ex1;

import aula05.ex1.DateYMD;

public class Person {
    // Declarations
    private String name;
    private int citizenCardNumber;
    private DateYMD dateOfBorn;

    public Person(String name, int citizenCardNumber, DateYMD dateOfBorn){
        if(isPersonValid(name,citizenCardNumber,dateOfBorn)){
            setName(name);
            setCitizenCardNumber(citizenCardNumber);
            setDateOfBorn(dateOfBorn);
        }
        else System.out.println("The Person is undefined");
    }

    // Create Person only with name (for ex2)
    public Person(String name){
        if(isPersonValid(name)){
            setName(name);
        }
        else System.out.println("The Person is undefined");
    }


    // Public methods
    public static boolean isPersonValid(String name, int citizenCardNumber, DateYMD dateOfBorn){
        // names must be more than 3 characters
        // citizenCardNumber must have 8 digits
        //  if the date is not correct --> dateOfBorn.day == 0

        return (name.length()>=3 && (String.valueOf(citizenCardNumber).length()==7) && dateOfBorn.getDay() != 0);
    }
    public static boolean isPersonValid(String name){
        // names must be more than 3 characters

        return name.length()>=3;
    }


    @Override
    public String toString(){
        String result = getName();
        return (getCitizenCardNumber() == 0 || getDateOfBorn() == null) ? result :
                result + "; CC: " + getCitizenCardNumber() + "; Date of Born: " + getDateOfBorn().getFormatted();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        if (getCitizenCardNumber() != person.getCitizenCardNumber()) return false;
        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) return false;
        return getDateOfBorn() != null ? getDateOfBorn().equals(person.getDateOfBorn()) : person.getDateOfBorn() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getCitizenCardNumber();
        result = 31 * result + (getDateOfBorn() != null ? getDateOfBorn().hashCode() : 0);
        return result;
    }

    // Getters

    public String getName() {
        return this.name;
    }

    public int getCitizenCardNumber() {
        return this.citizenCardNumber;
    }

    public DateYMD getDateOfBorn() {
        return this.dateOfBorn;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCitizenCardNumber(int citizenCardNumber) {
        this.citizenCardNumber = citizenCardNumber;
    }

    public void setDateOfBorn(DateYMD dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }
}
