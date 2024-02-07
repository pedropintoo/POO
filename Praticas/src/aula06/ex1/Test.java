package aula06.ex1;

import aula05.ex1.DateYMD;

public class Test {
    public static void main(String[] args) {
        // Fiz algumas alterações nos nomes das função pois não tinha reparado
        // que era fornecido uma lista de testes para testar o funcionamento das Classes.
        // Adaptei ao que já tinha feito, sem modificar muito.

        Student al = new Student("Andreia Melo", 9855678, new DateYMD(18, 7, 1990), new DateYMD(1, 9, 2018));
        Teacher pl = new Teacher("Andreia Melo", 9855678, new DateYMD(18, 7, 1990), "full","DETI");
        ScholarshipHolder bls = new ScholarshipHolder("Igor Santos", 8976543, new DateYMD(11, 5, 1985), pl, 900);
        bls.setScholarshipAmount(1050);
        System.out.println("Student: " + al.getName());
        System.out.println(al);
        System.out.println("Scholarship holder: " + bls.getName() + ", nIdentifier: " + bls.getNumericIdentifier() + ", Scholarship amount: " + bls.getScholarshipAmount() + ", Teacher advisor: " + bls.getTeacherAdvisor().getName());
        System.out.println(bls);
    }
}
