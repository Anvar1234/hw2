package service;

import model.Book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookLibrary {
    private final List<Book> books;

    public BookLibrary(List<Book> books) {
        this.books = books;
    }

    /**
     * Основной публичный метод для получения мапы, где ключ - это Автор+Жанр, а значение - список книг,
     * написанных данным автором в данном жанре.
     */
    public Map<String, List<Book>> getLibrary() {
        return books.stream().collect(Collectors.groupingBy((p) ->
                ("Автор = " + p.getAuthor().getName() + ", Жанр = " + p.getGenre().getName())));
    }
}