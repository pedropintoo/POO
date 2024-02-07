package aula06.ex1;

import aula05.ex1.DateYMD;

public class Teacher extends Person{
    // Declarations
    private String academicLevel;
    private String department;

    Teacher(String name, int citizenCardNumber, DateYMD dateOfBorn, String academicLevel, String department){
        super(name, citizenCardNumber, dateOfBorn);

        setAcademicLevel(academicLevel);
        setDepartment(department);
    }

    @Override
    public String toString(){
        return super.toString() + "; Academic level: " + getAcademicLevel() + "; Department: " + getDepartment();
    }

    // Getters

    public String getAcademicLevel() {
        return this.academicLevel;
    }

    public String getDepartment() {
        return this.department;
    }

    // Setters

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
