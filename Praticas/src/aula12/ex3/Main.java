package aula12.ex3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("src/aula12/ex3/movies.txt"));

        String[] cabecalho = input.nextLine().split("\t"); // Cabeçalho

        Set<Movie> moviesByName = new TreeSet<>(Comparator.comparing((movie) -> movie.getName().toLowerCase()));

        String line;
        String[] words;

        // name	score	rating	genre	running time
        while(input.hasNextLine()){
            line = input.nextLine();
            words = line.split("\t");
            moviesByName.add(new Movie(words[0], Double.valueOf(words[1]), words[2], MovieGenre.valueOf(words[3].toUpperCase()), Integer.parseInt(words[4])));

        }


        // b)

        System.out.println("\n"); // 2 linhas
        System.out.println("------ By Name -------");
        System.out.println(printCabecalho(cabecalho));
        moviesByName.forEach(System.out::println);

        // c)

        System.out.println("\n"); // 2 linhas
        System.out.println("------ By Score Reversed -------");
        System.out.println(printCabecalho(cabecalho));
        moviesByName.stream()
                .sorted(Comparator.comparing(Movie::getScore).reversed())
                .forEach(System.out::println);

        System.out.println("\n"); // 2 linhas
        System.out.println("------ By running Time -------");
        System.out.println(printCabecalho(cabecalho));
        moviesByName.stream()
                .sorted(Comparator.comparing(Movie::getRunningTime))
                .forEach(System.out::println);

        // d)

        System.out.println("\n"); // 2 linhas
        moviesByName.stream()
                .collect(Collectors.groupingBy(Movie::getGenre))
                .forEach((movieGenre, movies) -> System.out.println(movieGenre + " ("+movies.size()+")"));

        // e)

        System.out.println();
        Scanner sc = new Scanner(System.in);
        String genreSelection;

        System.out.print("My selection Genre: ");
        genreSelection = sc.next();

        StringBuilder content = new StringBuilder();
        moviesByName.stream()
                .filter(m -> m.getScore() > 60 && m.getGenre().name().equalsIgnoreCase(genreSelection))
                .forEach(m -> content.append(m).append("\n"));

        System.out.println(content);

        generateFileWith(content, "myselection.txt");

    }
    public static String printCabecalho(String[] cabecalho){
        return String.format("%-40s|%-15s|%-15s|%-15s|%-15s", cabecalho[0], cabecalho[1], cabecalho[2], cabecalho[3], cabecalho[4]);
    }

    public static void generateFileWith(StringBuilder content, String file) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("src/aula12/ex3/"+file);

        out.print(content);

        out.close();
    }
}
