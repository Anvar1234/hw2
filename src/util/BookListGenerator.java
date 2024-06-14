package util;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookListGenerator {

    /**
     * Основной публичный метод для получения списка сгенерированных книг.
     * В аргументы принимает (уже нет) реализацию интерфейса List, куда предполагается добавлять новые книги.
     */
    public static List<Book> generateBookList() {
       List<Book> books = new ArrayList<>(); //нужно ли так жестко прописывать реализацию?
        int howManyBooks = 100;
        for (int i = 0; i < howManyBooks; i++) {
            books.add(Book.getGeneratedBook());
        }
        return books;
    }
}
