package aula10.ex2;

public class Main {
    public static void main(String[] args){

        Library library = new Library();

        Book book1 = new Book("A Divina Comédia", "Dante Alighieri", 1320);
        Book book2 = new Book("Orgulho e Preconceito", "Jane Austen", 1813);
        Book book3 = new Book("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        Book book4 = new Book("Cem Anos de Solidão", "Gabriel Garcia Marquez", 1967);
        Book book5 = new Book("A Menina que Roubava Livros", "Markus Zusak", 2005);
        Book book6 = new Book("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997);
        Book book7 = new Book("1984", "George Orwell", 1949);
        Book book8 = new Book("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943);
        Book book9 = new Book("A Revolução dos Bichos", "George Orwell", 1945);
        Book book10 = new Book("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881);

        library.addBook(LiteraryGenre.DRAMA, book1);
        library.addBook(LiteraryGenre.HISTORICO, book2);
        library.addBook(LiteraryGenre.HORROR, book3);
        library.addBook(LiteraryGenre.MISTERIO, book4);
        library.addBook(LiteraryGenre.ROMANCE, book5);
        library.addBook(LiteraryGenre.DRAMA, book6);
        library.addBook(LiteraryGenre.HISTORICO, book7);
        library.addBook(LiteraryGenre.HORROR, book8);
        library.addBook(LiteraryGenre.MISTERIO, book9);
        library.addBook(LiteraryGenre.ROMANCE, book10);

        library.removeBook(book6);
        library.removeBook(book6);
        library.removeBook(book10);

        library.change(book2, book8);
        

        System.out.println(library);

        // bookOf()

        Book lastBook = library.bookOf(LiteraryGenre.MISTERIO);
        System.out.println(lastBook);

        library.removeBook(lastBook);

        // Tem de escolher obrigatoriamente o outro porque só eram 2
        System.out.println(library.bookOf(LiteraryGenre.MISTERIO));
    }
}
