package aula06.ex2;

import aula06.ex1.Person;

public class Contact {
    // Declarations
    private Person contactPerson;
    private int cellPhoneNumber;
    private String emailAddress;
    private int ID;

    public static int counterID = 1;

    Contact(Person contactPerson, int cellPhoneNumber, String emailAddress){
        if(isContactValid(contactPerson, cellPhoneNumber, emailAddress)){
            setContactPerson(contactPerson);
            setCellPhoneNumber(cellPhoneNumber);
            setEmailAddress(emailAddress);
            setID(Contact.counterID++);
        }
        else System.out.println("Contact is undefined!");

    }

    Contact(Person contactPerson, int cellPhoneNumber){
        this(contactPerson, cellPhoneNumber, "");
    }
    Contact(Person contactPerson, String emailAddress){
        this(contactPerson, 0, emailAddress);
    }


    @Override
    public String toString(){
        if(isCellPhoneNumberValid(getCellPhoneNumber()) && isEmailAddressValid(getEmailAddress())){
            return getID() + " - " + getContactPerson().getName() + " " + getCellPhoneNumber() + " " + getEmailAddress();
        }
        else if(isCellPhoneNumberValid(getCellPhoneNumber())){
            return getID() + " - " + getContactPerson().getName() + " " + getCellPhoneNumber();
        }
        else
            return getID() + " - " + getContactPerson().getName() + " " + getEmailAddress();

    }

    public static boolean isContactValid(Person contactPerson, int cellPhoneNumber, String emailAddress){
        // If contactPerson is invalid --> contactPerson.name == ""
        if(cellPhoneNumber != 0 && !emailAddress.equals("")){
            return !contactPerson.getName().equals("") && isCellPhoneNumberValid(cellPhoneNumber) && isEmailAddressValid(emailAddress);
        }
        return !contactPerson.getName().equals("") && (isCellPhoneNumberValid(cellPhoneNumber) || isEmailAddressValid(emailAddress));
    }

    public static boolean isCellPhoneNumberValid(int cellPhoneNumber){
        return String.valueOf(cellPhoneNumber).matches("^9\\d{8}$");
    }

    public static boolean isEmailAddressValid(String emailAddress){
        return emailAddress.matches("^\\w[a-zA-Z0-9_\\.]+@\\w+\\.\\w{2,}$");
    }

    // Getters

    public Person getContactPerson() {
        return this.contactPerson;
    }

    public int getCellPhoneNumber() {
        return this.cellPhoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public int getID() {
        return this.ID;
    }

    // Setters

    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setCellPhoneNumber(int cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


}
