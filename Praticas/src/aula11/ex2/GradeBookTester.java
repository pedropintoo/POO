package aula11.ex2;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class GradeBookTester {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new GradeBook instance
        GradeBook gradeBook = new GradeBook();

        // Load the student data from a text file
        gradeBook.load("alunos.txt");

        // Add a new student to the collection
        Student newStudent = new Student("Johny May", new ArrayList<>(List.of(10.0, 15.0, 19.0)));
        gradeBook.addStudent(newStudent);

        // Remove a student from the collection
        gradeBook.removeStudent("Jane Smith");


        // Retrieve a student from the collection
        Student student = gradeBook.getStudent("John Doe");

        // Calculate the average grade for a specific student
        double averageGrade = gradeBook.calculateAverageGrade("John Doe");
        System.out.println("Average grade for John Doe: " + averageGrade);

        // Print a summary of all students in the collection
        gradeBook.printAllStudents();
    }
}

