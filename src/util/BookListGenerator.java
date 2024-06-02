package util;

import model.Author;
import model.impl.AuthorGenreKey;
import model.Book;
import model.Genre;

import java.util.List;

public class BookListGenerator {

    /**
     * Основной публичный метод для получения списка книг, где сочетание автор+жанр представлено
     * объектами класса AuthorGenreKey.
     * В аргументы принимает реализации интерфейса List:
     * первый параметр - это список, куда предполагается добавлять новые книги в методе generateBookList(List<Book> books).
     * второй - список, где сочетание автор+жанр представлено объектами класса AuthorGenreKey.
     */
    public static List<Book> generateAuthorGenreKeyBooks(List<Book> implementOfListToLoading, List<Book> implementOfListToReturning) {// можем использовать любую реализацию List, в зависимости от потребностей (добавлять/искать и тд).
        List<Book> books = generateBookList(implementOfListToLoading);

        for (Book book : books) {
            int id = book.getId();
            String title = book.getTitle();
            Author author = book.getAuthor();
            Genre genre = book.getGenre();
            String year = book.getYear();
            AuthorGenreKey key = new AuthorGenreKey(author, genre);
            implementOfListToReturning.add(Book.getBookWithAuthorGenreKey(key, id, title, year));
        }
        return implementOfListToReturning;
    }

    /**
     * Приватный вспомогательный метод для получения списка сгенерированных книг.
     * В аргументы принимает реализацию интерфейса List, куда предполагается добавлять новые книги.
     */
    private static List<Book> generateBookList(List<Book> books) { // можем использовать любую реализацию List, в зависимости от потребностей (добавлять/искать и тд).
        int howManyBooks = 100;
        for (int i = 0; i < howManyBooks; i++) {
            books.add(Book.getBook());
        }
        return books;
    }
}
