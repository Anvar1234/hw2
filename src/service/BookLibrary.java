package service;

import model.impl.AuthorGenreKey;
import model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookLibrary {
    private final List<Book> books;
    public BookLibrary(List<Book> books) { //на вход подаем буки с AuthorGenreKey.
        // Проверяем, что все книги имеют ключи типа AuthorGenreKey.
        for (Book book : books) {
            if (book.getKey() == null) {
                throw new IllegalArgumentException("Все книги в списке должны иметь ключи типа AuthorGenreKey");
            }
        }
        this.books = books;
    }

    /**
     * Основной публичный метод для получения мапы, где ключ - это Автор+Жанр, а значение - список книг,
     * написанных данным автором в данном жанре.
     */
    public Map<AuthorGenreKey, List<Book>> getLibrary(Map<AuthorGenreKey, List<Book>> implementOfMapToReturn) { //можем выбрать, какую реализацию мапы использовать.
        for (Book book : books) {
            AuthorGenreKey key = book.getKey();
            if (!implementOfMapToReturn.containsKey(key)) {
                // Добавляем ключ (Автор+Жанр) и список книг без автора и жанра в мапу.
                implementOfMapToReturn.put(key, getBooksWithoutAuthorAndGenre(key));
            }
        }
        return implementOfMapToReturn;
    }

    /**
     * Приватный вспомогательный метод для поиска и добавления в новый список книги по ключу "Автор + Жанр"
     * в общем списке книг.
     */
    private List<Book> getBooksWithoutAuthorAndGenre(AuthorGenreKey key) {
        // Создаем новый список для текущего ключа.
        List<Book> booksWithoutAuthorAndGenre = new ArrayList<>();
        // Добавляем все книги с текущим ключом в новый список
        for (Book bookValue : books) {
            if (key.equals(bookValue.getKey())) {
                //для создания новой версии книги используем конструктор без автора и жанра:
                Book bookWithoutAuthorAndGenre = Book.getBookWithoutAuthorAndGenre(bookValue.getId(), bookValue.getTitle(), bookValue.getYear());
                booksWithoutAuthorAndGenre.add(bookWithoutAuthorAndGenre);
            }
        }
        return booksWithoutAuthorAndGenre;
    }

}
