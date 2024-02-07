package aula10.ex2;

import java.util.*;

public class Library {
    // A ordem segue a ordem do enumerado
    private final Map<LiteraryGenre, HashSet<Book>> allBooks = new TreeMap<>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\n---------------------Library:---------------------");

        result.append("\n\n(genre-book)");
        for(Map.Entry<LiteraryGenre, HashSet<Book>> entry : allBooks.entrySet()){
            result.append("\n\t").append(entry.getKey().name());
            for(Book book : entry.getValue()) {
                result.append("\n\t\t").append(book);
            }
        }

        result.append("\n\n(genre)");
        for(LiteraryGenre genre : allBooks.keySet()){
            result.append("\n\t").append(genre.name());
        }

        result.append("\n\n(book)");
        for(HashSet<Book> bookHashSet: allBooks.values()){
            for(Book book : bookHashSet){
                result.append("\n\t").append(book);
            }

        }

        result.append("\n\n--------------------------------------------------");

        return result.toString();
    }

    public boolean addBook(LiteraryGenre genre, Book book){
        if(allBooks.containsKey(genre)){
            if(allBooks.get(genre).add(book)){
                System.out.println("Book has been added!");
                return true;
            }
        }
        else{
            allBooks.put(genre, new HashSet<Book>());
            if(allBooks.get(genre).add(book)){
                System.out.println("Book has been added!");
                return true;
            }
        }
        return false;
    }

    public boolean change(Book oldBook, Book newBook){
        for(Map.Entry<LiteraryGenre, HashSet<Book>> entry : allBooks.entrySet()){
            if(entry.getValue().contains(oldBook)){
                entry.getValue().remove(oldBook);
                entry.getValue().add(newBook);
                System.out.println("Book has been replaced!");
                return true;
            }
        }
        return false;
    }

    public boolean removeBook(Book book){
        for(Map.Entry<LiteraryGenre, HashSet<Book>> entry : allBooks.entrySet()){
            if(entry.getValue().contains(book)){
                entry.getValue().remove(book);
                System.out.println("Book has been removed from "+entry.getKey().name()+" !");
                return true;
            }
        }
        return false;
    }

    public Book bookOf(LiteraryGenre genre){
        if (allBooks.containsKey(genre)) {
            HashSet<Book> booksInGenre = allBooks.get(genre);
            int numBooks = booksInGenre.size();
            if (numBooks > 0) {
                int randomIndex = (int)(Math.random() * numBooks);
                Iterator<Book> iter = booksInGenre.iterator();
                for (int i = 0; i < randomIndex; i++) {
                    iter.next();
                }
                return iter.next();
            }
        }
        return null;
    }
}
