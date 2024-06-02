package runner;

import model.Book;
import model.impl.AuthorGenreKey;
import service.BookLibrary;
import util.BookListGenerator;

import java.util.*;

public class ApplicationRunner{

    public static void run() {
        List<Book> books = BookListGenerator.generateAuthorGenreKeyBooks(new ArrayList<>(), new ArrayList<>());
        Collections.sort(books);
        System.out.println("Список сгенерированных книг: ");
        for (Book book : books){
            System.out.println(book);
        }
        System.out.println();

        System.out.println("Список книг, сгруппированных по ключу \"Автор + Жанр\": ");
        BookLibrary bookLibrary = new BookLibrary(books);
        Map<AuthorGenreKey, List<Book>> rangedBooks = bookLibrary.getLibrary(new HashMap<>());
        for (AuthorGenreKey key : rangedBooks.keySet()){
            System.out.println(key);
            for(Book book : rangedBooks.get(key)){
                System.out.println(book);
            }
            System.out.println();
        }
    }
}
