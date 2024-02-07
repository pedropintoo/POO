package aula07.Av1;

public class Book extends LibraryItem{
    private String name;

    Book(String title, String name) {
        super(title);
        this.name = name;
    }
}
