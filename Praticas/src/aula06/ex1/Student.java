package aula06.ex1;

import aula05.ex1.DateYMD;
import java.time.LocalDateTime;

public class Student extends Person{
    // Declarations
    private static int counterIdentifier = 100;
    private int numericIdentifier;
    private DateYMD dateOfEnrollment;



    Student(String name, int citizenCardNumber, DateYMD dateOfBorn, DateYMD dateOfEnrollment) {
        super(name, citizenCardNumber, dateOfBorn);
        // Only if Person has been created successfully
        if(Person.isPersonValid(name,citizenCardNumber,dateOfBorn)){
            // current Date if dateOfEnrollment == null
            if(dateOfEnrollment != null) setDateOfEnrollment(dateOfEnrollment);
            else setDateOfEnrollment(getCurrentDate());

            this.numericIdentifier = Student.counterIdentifier++;
        }
    }

    Student(String name, int citizenCardNumber, DateYMD dateOfBorn) {
        this(name, citizenCardNumber, dateOfBorn, null);
    }

    @Override
    public String toString(){
        return super.toString() + "; nIdentifier: " + getNumericIdentifier() + "; Date of enrolment: " + getDateOfEnrollment().getFormatted();
    }

    // Getters

    public int getNumericIdentifier() {
        return this.numericIdentifier;
    }
    public DateYMD getDateOfEnrollment() {
        return this.dateOfEnrollment;
    }
    public DateYMD getCurrentDate(){
        LocalDateTime now = LocalDateTime.now();
        return new DateYMD(now.getDayOfMonth(),now.getMonthValue(),now.getYear());
    }

    // Setters

    public void setDateOfEnrollment(DateYMD dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }
}
