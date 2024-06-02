package model.impl;

import model.Author;
import model.Genre;

import java.util.Objects;

public class AuthorGenreKey {
    private final Author author;
    private final Genre genre;

    public AuthorGenreKey(Author author, Genre genre) {
        this.author = author;
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Автор = " + author.getName() +
                ", Жанр = " + genre.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AuthorGenreKey other = (AuthorGenreKey) obj;
        return (Objects.equals(author, other.author))
                && (Objects.equals(genre, other.genre));
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, genre);
    }
}
