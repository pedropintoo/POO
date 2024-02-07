package aula06.ex1;

import aula05.ex1.DateYMD;

public class ScholarshipHolder extends Student{
     private Teacher teacherAdvisor;
     private double scholarshipAmount;

     ScholarshipHolder(String name, int citizenCardNumber, DateYMD dateOfBorn, Teacher teacherAdvisor, double scholarshipAmount){
         super(name, citizenCardNumber, dateOfBorn);

         setTeacherAdvisor(teacherAdvisor);
         setScholarshipAmount(scholarshipAmount);
     }

    @Override
    public String toString(){
        return super.toString() + "; Teacher Advisor: " + getTeacherAdvisor().getName() + "; Scholarship amount: " + getScholarshipAmount();
    }

     // Getters

    public Teacher getTeacherAdvisor() {
        return this.teacherAdvisor;
    }

    public double getScholarshipAmount() {
        return this.scholarshipAmount;
    }

    // Setters

    public void setTeacherAdvisor(Teacher teacherAdvisor) {
        this.teacherAdvisor = teacherAdvisor;
    }

    public void setScholarshipAmount(double scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }
}
