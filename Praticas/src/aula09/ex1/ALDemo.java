package aula09.ex1;

import aula05.ex1.DateYMD;
import aula06.ex1.Person;
import aula07.ex2.Date;
import aula07.ex2.DateND;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.TreeSet;

public class ALDemo {
    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();

        // Adicionar multiplos de 10 {10,20,30,40,50,60,70,80,90,100}
        for (int i = 10; i <= 100; i+=10)
            c1.add(i);

        System.out.println("Size: " + c1.size());
        //  Imprimir os elementos
        for (Integer integer : c1) System.out.println("Elemento: " + integer);

        // #####################################################################

        ArrayList<String> c2 = new ArrayList<>();

        // Adicionar
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        c2.add("Chuva"); // repetido
        System.out.println(c2); // Ordenados pela ordem de adicao

        Collections.sort(c2); // Ordem alfabetica
        System.out.println(c2);

        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);

        if (c2.contains("Chuva") && (c2.indexOf("Chuva") != c2.lastIndexOf("Chuva"))) {
            System.out.println("A lista contem chuva em: "+c2.indexOf("Chuva")+" e "+c2.lastIndexOf("Chuva"));
            c2.set(c2.lastIndexOf("Chuva"),"ChuvaRepetida");
        }
        System.out.println(c2);

        // #####################################################################
        // TODO: Tive de implementar o equals() e o hashcode() na class Person e da DateYMD

        Set<Person> c3 = new HashSet<>();
        c3.add(new Person("Pedro",1112223,new DateYMD(7,10,2004)));
        c3.add(new Person("Joao",1234567,new DateYMD(12,10,2007)));
        c3.add(new Person("Pedro",1928374,new DateYMD(23,12,2012)));
        c3.add(new Person("Henrique",9876543,new DateYMD(17,9,1999)));
        c3.add(new Person("Pedro",1112223,new DateYMD(7,10,2004))); // Repetido

        // Iterador 1
        Iterator<Person> itr1 = c3.iterator();
        while ( itr1.hasNext() )
            System.out.println( "\t" + itr1.next() );

        // #####################################################################
        // TODO: Tive de implementar Comparable na class Date

        Set<Date> c4 = new TreeSet<>();

        c4.add(new DateND(-500));
        c4.add(new DateND(10));
        c4.add(new DateND(2000));
        c4.add(new aula07.ex2.DateYMD(7,10,2004)); // Este DateYMD é diferente do anteriormente utilizado !!!
        c4.add(new aula07.ex2.DateYMD(7,3,2002));
        c4.add(new aula07.ex2.DateYMD(7,3,2002)); // Repetido
        c4.add(new DateND(10)); // Repetido

        // Iterador 2
        Iterator<Date> itr2 = c4.iterator();
        while ( itr2.hasNext() )
            System.out.println( "\t\t" + itr2.next() );
    }
}