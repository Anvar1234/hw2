package util;

import model.Genre;

import java.util.Random;

public class GenreRandomizer {
    public static Genre getRandomGenre() {
        Genre[] genres = Genre.values();
        Random random = new Random();
        return genres[random.nextInt(genres.length)];
    }
}
