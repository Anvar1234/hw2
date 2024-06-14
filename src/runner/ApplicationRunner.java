package runner;

import model.Book;
import service.BookLibrary;
import util.BookListGenerator;

import java.util.*;

public class ApplicationRunner {

    public static void run() {
        List<Book> books = BookListGenerator.generateBookList();
        Collections.sort(books);
        System.out.println("Список сгенерированных книг: ");
        books.forEach(System.out::println);

        System.out.println();

        System.out.println("Список книг, сгруппированных по ключу \"Автор + Жанр\": ");
        BookLibrary bookLibrary = new BookLibrary(books);
        Map<String, List<Book>> groupedBooks = bookLibrary.getLibrary();
        groupedBooks.forEach((key, value) -> {
            System.out.println("\n" + key);
            value.forEach(System.out::println);
        });
    }
}

