package model;

import model.impl.AuthorGenreKey;
import util.AuthorRandomizer;
import util.GenreRandomizer;
import util.TitleGenerator;
import util.YearRandomizer;

public class Book implements Comparable<Book> {
    private static int idCounter = 0; // статическое поле для отслеживания всех идентификаторов.
    private final int id; // финальное поле для уникального идентификатора книги.
    private final String title;
    private Author author;
    private Genre genre;
    private final String year;
    private AuthorGenreKey key;

    private Book() {
        this.id = ++idCounter;
        this.title = TitleGenerator.generateTitle();
        this.author = AuthorRandomizer.getRandomAuthor();
        this.genre = GenreRandomizer.getRandomGenre();
        this.year = YearRandomizer.getRandomYear(1995, 2024);
    }
    private Book(int id, String title, String year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }
    private Book(AuthorGenreKey key, int id, String title, String year) {
        this.key = key;
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public static Book getBook() {
        return new Book();
    }

    public static Book getBookWithoutAuthorAndGenre(int id, String title, String year) {
        return new Book(id, title, year);
    }

    public static Book getBookWithAuthorGenreKey(AuthorGenreKey key, int id, String title, String year) {
        return new Book(key, id, title, year);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public AuthorGenreKey getKey() {
        return key;
    }

    @Override
    public String toString() {
        if (this.key != null) {
            return "Книга: " +
                    "id = " + id +
                    ", Название = " + '\"' + title + '\"' +
                    ", Автор = " + key.getAuthor().getName()
                    +
                    ", Жанр = " + key.getGenre().getName()
                    +
                    ", Год издания = " + year +
                    ".";
        }
        if (author == null) {
            return "Книга: " +
                    "id = " + id +
                    ", Название = " + '\"' + title + '\"' +
                    ", Год издания = " + year +
                    ".";
        }
        return "Книга: " +
                "id = " + id +
                ", Название = " + '\"' + title + '\"' +
                ", Автор = " + author.getName() +
                ", Жанр = " + genre.getName() +
                ", Год издания = " + year +
                ".";
    }
    @Override
    public int compareTo(Book otherBook) {
        return Integer.compare(Integer.parseInt(this.year), Integer.parseInt(otherBook.year));
    }
}
