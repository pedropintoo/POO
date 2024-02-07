package aula11.ex2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class GradeBook {

    HashSet<Student> students = new HashSet<>();

    public void load(String s) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("src/aula11/ex2/alunos.txt"));

        while (input.hasNextLine()){
            // John Doe|12.5|14|10.75
            String line = input.nextLine();
            String[] words = line.split("\\|");

            ArrayList<Double> grades = new ArrayList<>();
            for(int i = 1; i < words.length; i++){
                grades.add(Double.valueOf(words[i]));
            }
            addStudent(new Student(words[0], grades));
        }
    }


    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public void removeStudent(String studentName) {
        students.removeIf(student -> student.getName().equals(studentName));
    }

    public Student getStudent(String studentName) {
        for(Student student : students){
            if(Objects.equals(student.getName(), studentName)){
                return student;
            }
        }
        return null;
    }

    public double calculateAverageGrade(String studentName) {
        SimpleGradeCalculator simpleGradeCalculator = new SimpleGradeCalculator();
        return simpleGradeCalculator.calculate(getStudent(studentName).getGrades());
    }

    public void printAllStudents() {
        for(Student student : students){
            System.out.println(student);
        }
    }
}
