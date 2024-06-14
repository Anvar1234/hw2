package model;

import util.AuthorRandomizer;
import util.GenreRandomizer;
import util.TitleGenerator;
import util.YearRandomizer;

public class Book implements Comparable<Book> {
    private static int idCounter = 0;
    private final int id;
    private final String title;
    private final Author author;
    private final Genre genre;
    private final int year;

    private Book(int id, String title, Author author, Genre genre, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    public static Book getGeneratedBook() {
        int id = ++idCounter;
        String title = TitleGenerator.generateTitle();
        Author author = AuthorRandomizer.getRandomAuthor();
        Genre genre = GenreRandomizer.getRandomGenre();
        int year = YearRandomizer.getRandomYear(1995, 2024);
        return new Book(id, title, author, genre, year);
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }


    @Override
    public String toString() {
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
        return Integer.compare(this.year, otherBook.year);
    }
}
