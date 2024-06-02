package util;

import model.Author;

import java.util.Random;

public class AuthorRandomizer {
    public static Author getRandomAuthor(){
        Random random = new Random();
        Author[] authors = Author.values();
        return authors[random.nextInt(authors.length)];
    }
}
